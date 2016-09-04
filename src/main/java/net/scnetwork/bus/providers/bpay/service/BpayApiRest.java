package net.scnetwork.bus.providers.bpay.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.rest.RestApi;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * REST API для настройки сервиса bpay
 */
@RestController
public class BpayApiRest implements RestApi{

    @RequestMapping(value = "/rest/modules/bpay/get/{parameter}")
    @Override
    public String getApi(@PathParam(value = "parameter") @NotNull String parameter) {
        switch (parameter) {
            case "info":
                return getConfig();
            case "service":
                return getService();
            case "url":
                return getUrl();
            case "use":
                return String.valueOf(getUse());
            case "point":
                return getPoint();
            case "merchant":
                return getMerchant();
            case "signature":
                return getSignature();
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.toString();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/bpay/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                bPay.setUse(use);
                bPay.setService(service.toUpperCase());
                bPay.setUrl(url);

                modules.setBpay(bPay);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/bpay/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                bPay.setUse(use);
                modules.setBpay(bPay);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getService() {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.getService();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/bpay/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                bPay.setService(service.toUpperCase());
                modules.setBpay(bPay);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getUrl() {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.getUrl();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/module/bpay/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                bPay.setUrl(url);
                modules.setBpay(bPay);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    /**
     * Адрес стороннего сервиса
     * @return адрес
     */
    public String getPoint() {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.getPoint();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }


    /**
     * Идентификатор мерчанта
     * @return идентификатор
     */
    public String getMerchant() {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.getMerchantId();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    /**
     * Подпись
     * @return подпись
     */
    public String getSignature(){
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.getSignature();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }
}
