package net.scnetwork.bus.providers.forex.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.forex.config.Forex;
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
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                return forex.toString();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/forex/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/forex/get/use")
    @Override
    public boolean getUse() {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/forex/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") boolean use) {
        return false;
    }
}
