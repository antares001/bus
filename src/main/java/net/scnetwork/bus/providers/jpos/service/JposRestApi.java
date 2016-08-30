package net.scnetwork.bus.providers.jpos.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.jpos.config.JposConfig;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

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
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/get/use")
    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                return jpos.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        return false;
    }
}
