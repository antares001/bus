package net.scnetwork.bus.providers.qiwi.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Настройка модуля qiwi
 */
public class QiwiRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/qiwi/get/info")
    @Override
    public String getConfig() {
        return null;
    }
}
