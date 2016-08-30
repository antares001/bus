package net.scnetwork.bus.providers.forex.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Настройка модуля Forex
 */
public class ForexRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/forex/get/info")
    @Override
    public String getConfig() {
        return null;
    }
}
