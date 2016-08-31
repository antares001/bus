package net.scnetwork.bus.providers.jpos.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.jpos.config.JposConfig;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Настройка модуля Jpos
 */
@RestController
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
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                jpos.setUse(use);
                jpos.setService(service.toUpperCase());
                jpos.setUrl(url);

                modules.setJpos(jpos);
                Config.setModules(modules);
                return true;
            }
        }
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
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                jpos.setUse(use);
                modules.setJpos(jpos);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/get/service")
    @Override
    public String getService() {
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                return jpos.getService();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                jpos.setService(service.toUpperCase());
                modules.setJpos(jpos);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/get/url")
    @Override
    public String getUrl() {
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                return jpos.getUrl();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                jpos.setUrl(url);
                modules.setJpos(jpos);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
