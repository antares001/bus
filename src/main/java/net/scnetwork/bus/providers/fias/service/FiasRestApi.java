package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Настройка модуля ФИАС
 */
public class FiasRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/fias/get/info")
    @Override
    public String getConfig() {
        return null;
    }
}
