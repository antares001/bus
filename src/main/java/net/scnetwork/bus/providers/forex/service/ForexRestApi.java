package net.scnetwork.bus.providers.forex.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.forex.config.Forex;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Настройка модуля Forex
 */
@RestController
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
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull  String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                forex.setUse(use);
                forex.setService(service.toUpperCase());
                forex.setUrl(url);

                modules.setForex(forex);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/forex/get/use")
    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                return forex.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/forex/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                forex.setUse(use);
                modules.setForex(forex);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/forex/get/service")
    @Override
    public String getService() {
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                return forex.getService();
            }
        }
        return null;
    }
}
