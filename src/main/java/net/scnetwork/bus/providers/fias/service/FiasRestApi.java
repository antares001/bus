package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.fias.config.Fias;
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
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                return fias.toString();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/get/use")
    @Override
    public boolean getUse() {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") boolean use) {
        return false;
    }
}
