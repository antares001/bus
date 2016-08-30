package net.scnetwork.bus.providers.qiwi.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.qiwi.config.Qiwi;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

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
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi){
                qiwi.setUse(use);
                qiwi.setService(service.toUpperCase());
                qiwi.setUrl(url);

                modules.setQiwi(qiwi);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/get/use")
    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi){
                return qiwi.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules){
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi){
                qiwi.setUse(use);
                modules.setQiwi(qiwi);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
