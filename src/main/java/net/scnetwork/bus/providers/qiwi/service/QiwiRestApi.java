package net.scnetwork.bus.providers.qiwi.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.qiwi.config.Qiwi;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * Настройка модуля qiwi
 */
@RestController
public class QiwiRestApi implements RestApiStandard {
    @Autowired
    private Qiwi qiwi;

    @RequestMapping(value = "/rest/api/modules/qiwi/get/{parameter}")
    @Override
    public String getApi(@PathParam(value = "parameter") @NotNull String parameter) {
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
        if (null != qiwi) {
            return qiwi.toString();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi) {
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

    @Override
    public boolean getUse() {
        if (null != qiwi) {
            return qiwi.isUse();
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi) {
                qiwi.setUse(use);
                modules.setQiwi(qiwi);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getService() {
        if (null != qiwi) {
            return qiwi.getService();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi) {
                qiwi.setService(service.toUpperCase());
                modules.setQiwi(qiwi);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getUrl() {
        if (null != qiwi) {
            return qiwi.getUrl();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/qiwi/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi) {
                qiwi.setUrl(url);
                modules.setQiwi(qiwi);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
