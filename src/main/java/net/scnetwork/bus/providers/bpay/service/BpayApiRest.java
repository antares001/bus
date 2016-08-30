package net.scnetwork.bus.providers.bpay.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * REST API для настройки сервиса bpay
 */
public class BpayApiRest implements RestApi{
    @RequestMapping(value = "/rest/api/modules/bpay/get/info")
    @Override
    public String getConfig() {
        return null;
    }
}
