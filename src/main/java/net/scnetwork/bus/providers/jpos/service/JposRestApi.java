package net.scnetwork.bus.providers.jpos.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.jpos.config.Jpos;
import net.scnetwork.bus.rest.RestApi;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * Настройка модуля Jpos
 */
@RestController
public class JposRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/jpos/get/{parameter}")
    @Override
    public String getApi(@PathParam(value = "parameter") @NotNull String parameter) {
        switch (parameter){
            case "info":
                return getConfig();
            case "server":
                return getService();
            case "url":
                return getUrl();
            case "use":
                return String.valueOf(getUse());
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            Jpos jpos = modules.getJpos();
            if (null != jpos){
                return jpos.toString();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Jpos jpos = modules.getJpos();
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

    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            Jpos jpos = modules.getJpos();
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
            Jpos jpos = modules.getJpos();
            if (null != jpos){
                jpos.setUse(use);
                modules.setJpos(jpos);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getService() {
        Modules modules = Config.getModules();
        if (null != modules){
            Jpos jpos = modules.getJpos();
            if (null != jpos){
                return jpos.getService();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules){
            Jpos jpos = modules.getJpos();
            if (null != jpos){
                jpos.setService(service.toUpperCase());
                modules.setJpos(jpos);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getUrl() {
        Modules modules = Config.getModules();
        if (null != modules){
            Jpos jpos = modules.getJpos();
            if (null != jpos){
                return jpos.getUrl();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/jpos/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Jpos jpos = modules.getJpos();
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
