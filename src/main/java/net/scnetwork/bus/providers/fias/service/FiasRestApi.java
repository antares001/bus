package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Настройка модуля ФИАС
 */
@RestController
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
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                fias.setUse(use);
                fias.setService(service.toUpperCase());
                fias.setUrl(url);
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/get/use")
    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                return fias.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                fias.setUse(use);
                modules.setFias(fias);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/get/service")
    @Override
    public String getService() {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                return fias.getService();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                fias.setService(service.toUpperCase());
                modules.setFias(fias);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/get/url")
    @Override
    public String getUrl() {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                return fias.getUrl();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                fias.setUrl(url);
                modules.setFias(fias);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
