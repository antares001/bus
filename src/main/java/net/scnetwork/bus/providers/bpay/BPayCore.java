package net.scnetwork.bus.providers.bpay;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.providers.bpay.domain.DataReqBpay;
import net.scnetwork.bus.providers.bpay.domain.BPayOptions;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.bpay.enums.BPayLang;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.LogBus;
import net.scnetwork.bus.utils.XmlUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Обработка запросов сервиса BPay
 */
public class BPayCore implements IProviders{
    private BPay bPay;

    /**
     * Инициализация конфигурации
     */
    public BPayCore(){
        try{
            bPay =  Config.getInstance().getModules().getBpay();
        } catch (NullPointerException e) {
            LogBus.writeLog(e);
        }
    }

    @Override
    public Response processingXml(DataRequest data) {
        if (null != bPay) {
            if (bPay.isUse()) {
                switch (UseEnum.valueOf(bPay.getService())) {
                    case LOCAL:
                        return localProcessingXml(data);
                    case REMOTE:
                        return remoteProcessingXml(data);
                    case NONE:
                    default:
                        return XmlUtils.getError(StatusEnum.ERROR_CONFIG);
                }
            } else {
                return XmlUtils.getError(StatusEnum.SERVICE_DISABLED);
            }
        } else {
            return XmlUtils.getError(StatusEnum.SERVICE_NOT_FOUND);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (null != bPay) {
            if (bPay.isUse()) {
                switch (UseEnum.valueOf(bPay.getService())) {
                    case LOCAL:
                        return localProcessingJson(data);
                    case REMOTE:
                        return remoteProcessingJson(data);
                    case NONE:
                    default:
                        return JsonUtils.getError(StatusEnum.ERROR_CONFIG);
                }
            } else {
                return JsonUtils.getError(StatusEnum.SERVICE_DISABLED);
            }
        } else {
            return JsonUtils.getError(StatusEnum.SERVICE_NOT_FOUND);
        }
    }

    @Override
    public Response localProcessingXml(DataRequest data) {
        BPayOptions options = ((DataReqBpay) data).getbPayOptions();

        Payment payment = new Payment();
        switch (options.getOperation()) {
            case BILL:
                payment = createInfo(bPay, options);
                break;
            case CALLBACK:
                payment.setType("1.2");
                payment.setOrderId(options.getOrder());
                payment.setAmount(options.getAmount());
                payment.setValute(options.getCurrency());
                break;
            case PAY:
            case INFO:
            default:
                break;
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Payment.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(payment, sw);
            String xml = sw.toString();

            String xmlData = Base64.getEncoder().encodeToString(xml.getBytes("UTF-8"));

            MessageDigest md = MessageDigest.getInstance("MD5");
            //TODO: make md5(md5(xmlData) + md5(signature))
        } catch (JAXBException | UnsupportedEncodingException | NoSuchAlgorithmException e) {
            LogBus.writeLog(e);
        }
        return null;
    }

    @Override
    public ResponseJs localProcessingJson(DataJs data) {
        return null;
    }

    @Override
    public Response remoteProcessingXml(DataRequest data) {
        return null;
    }

    @Override
    public ResponseJs remoteProcessingJson(DataJs data) {
        return null;
    }

    private Payment createInfo(BPay bPay, BPayOptions options){
        Payment payment = new Payment();
        payment.setType("1.2");
        payment.setMerchantId(bPay.getMerchantId());
        payment.setAmount(options.getAmount());
        payment.setDescription(options.getDescription());
        payment.setMethod(options.getMethod());
        payment.setOrderId(options.getOrder());
        payment.setSuccessUrl("");
        payment.setFailUrl("");
        payment.setCallbackUrl("");
        payment.setLang(BPayLang.RU);
        payment.setAdvanced1(" ");
        payment.setAdvanced2(" ");
        payment.setIstest(1);
        payment.setGetUrl(0);

        return payment;
    }
}
