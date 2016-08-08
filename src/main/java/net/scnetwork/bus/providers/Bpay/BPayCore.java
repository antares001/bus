package net.scnetwork.bus.providers.Bpay;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.modules.BPay;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class BPayCore implements IProviders{
    private BPay bPay = Config.getInstance().getModules().getBpay();

    @Override
    public Response processingXml(Data data) {
        if (null != bPay) {
            if (bPay.isUse()) {
                switch (UseEnum.valueOf(bPay.getService())) {
                    case LOCAL:
                        String point = bPay.getPoint();
                        BPayOptions options = data.getbPayOptions();

                        Payment payment = new Payment();
                        switch (options.getOperation()) {
                            case BILL:
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
                                break;
                            case CALLBACK:
                                payment.setType("1.2");
                                payment.setOrderId(options.getOrder());
                                payment.setAmount(options.getAmount());
                                payment.setValute(options.getCurrency());
                                break;
                            case PAY:
                                break;
                            case INFO:
                                break;
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
                            e.printStackTrace();
                        }
                        break;
                    case REMOTE:
                        String microservice = bPay.getUrl();
                        break;
                    case NONE:
                        break;
                    default:
                        return XmlUtils.getError(StatusEnum.ERROR_CONFIG);
                }
                return XmlUtils.getError(StatusEnum.OK);
            } else {
                return XmlUtils.getError(StatusEnum.NOT_SUPPORT);
            }
        } else {
            return XmlUtils.getError(StatusEnum.NULL);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (bPay.isUse()) {
            switch (UseEnum.valueOf(bPay.getService())){
                case LOCAL:
                    String point = bPay.getPoint();
                    break;
                case REMOTE:
                    String microservice = bPay.getUrl();
                    break;
                case NONE:
                    break;
                default:
                    JsonUtils.getError(StatusEnum.ERROR_CONFIG);
            }
            return null;
        } else {
            return JsonUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }

}
