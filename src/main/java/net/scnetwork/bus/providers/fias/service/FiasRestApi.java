package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * Настройка модуля ФИАС
 */
@RestController
public class FiasRestApi implements RestApiStandard {
    @Autowired
    private Fias fias;

    @RequestMapping(value = "/rest/modules/fias/get/{parameter}")
    @Override
    public String getApi(@PathParam(value = "parameter/") @NotNull String parameter) {
        switch (parameter) {
            case "info":
                return getConfig();
            case "service":
                return getService();
            case "use":
                return String.valueOf(getUse());
            case "url":
                return getUrl();
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @Override
    public String getConfig() {
        if (null != fias) {
            return fias.toString();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Fias fias = modules.getFias();
            if (null != fias) {
                fias.setUse(use);
                fias.setService(service.toUpperCase());
                fias.setUrl(url);
            }
        }
        return false;
    }

    @Override
    public boolean getUse() {
        if (null != fias) {
            return fias.isUse();
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Fias fias = modules.getFias();
            if (null != fias) {
                fias.setUse(use);
                modules.setFias(fias);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getService() {
        if (null != fias) {
            return fias.getService();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Fias fias = modules.getFias();
            if (null != fias) {
                fias.setService(service.toUpperCase());
                modules.setFias(fias);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getUrl() {
        if (null != fias) {
            return fias.getUrl();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Fias fias = modules.getFias();
            if (null != fias) {
                fias.setUrl(url);
                modules.setFias(fias);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
