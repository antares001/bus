package net.scnetwork.bus.providers.qiwi.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.qiwi.config.Qiwi;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Настройка модуля qiwi
 */
public class QiwiRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/qiwi/get/info")
    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi){
                return qiwi.toString();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/get/use")
    @Override
    public boolean getUse() {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") boolean use) {
        return false;
    }
}
