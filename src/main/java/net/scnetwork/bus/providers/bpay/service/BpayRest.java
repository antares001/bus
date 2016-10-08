package net.scnetwork.bus.providers.bpay.service;

import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

/**
 * REST API для настройки сервиса bpay
 */
@RestController
public class BpayRest implements RestApiStandard {
    @Autowired
    private BPay config;

    @RequestMapping(value = "/rest/modules/bpay/operation")
    public ResponseJs operation(@QueryParam(value = "type") String type){
        return JsonUtils.getError(StatusEnum.ERROR);
    }

    @RequestMapping(value = "/rest/modules/bpay/api")
    @Override
    public String getApi(@RequestParam(value = "parameter") @NotNull String parameter) {
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
        if (null != config) {
            return config.toString();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @Override
    public boolean getUse() {
        return null != config && config.isUse();
    }

    @Override
    public String getService() {
        if (null != config) {
            return config.getService();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @Override
    public String getUrl() {
        if (null != config) {
            return config.getUrl();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    /**
     * Адрес стороннего сервиса
     *
     * @return адрес
     */
    public String getPoint() {
        if (null != config) {
            return config.getPoint();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }


    /**
     * Идентификатор мерчанта
     *
     * @return идентификатор
     */
    public String getMerchant() {
        if (null != config) {
            return config.getMerchantId();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    /**
     * Подпись
     *
     * @return подпись
     */
    public String getSignature() {
        if (null != config) {
            return config.getSignature();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }
}
