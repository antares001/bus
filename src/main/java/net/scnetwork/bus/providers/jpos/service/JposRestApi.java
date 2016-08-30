package net.scnetwork.bus.providers.jpos.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.jpos.config.JposConfig;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Настройка модуля Jpos
 */
public class JposRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/jpos/get/info")
    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                return jpos.toString();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/get/use")
    @Override
    public boolean getUse() {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") boolean use) {
        return false;
    }
}
