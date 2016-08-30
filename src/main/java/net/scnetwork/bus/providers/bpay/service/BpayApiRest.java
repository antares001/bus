package net.scnetwork.bus.providers.bpay.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * REST API для настройки сервиса bpay
 */
public class BpayApiRest implements RestApi{
    @RequestMapping(value = "/rest/api/modules/bpay/get/info")
    @Override
    public String getConfig() {
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/bpay/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }
}
