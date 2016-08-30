package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Настройка модуля ФИАС
 */
public class FiasRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/fias/get/info")
    @Override
    public String getConfig() {
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }
}
