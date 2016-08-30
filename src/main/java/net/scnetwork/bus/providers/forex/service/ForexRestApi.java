package net.scnetwork.bus.providers.forex.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Настройка модуля Forex
 */
public class ForexRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/forex/get/info")
    @Override
    public String getConfig() {
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/forex/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }
}
