package net.scnetwork.bus.providers.forex.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.forex.config.Forex;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * Настройка модуля Forex
 */
@RestController
public class ForexRestApi implements RestApiStandard{
    @RequestMapping(value = "/rest/modules/forex/get/{parameter}")
    @Override
    public String getApi(@PathParam(value = "parameter") @NotNull String parameter) {
        switch (parameter){
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
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                return forex.toString();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
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
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/forex/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                forex.setService(service.toUpperCase());
                modules.setForex(forex);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/forex/get/url")
    @Override
    public String getUrl() {
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                return forex.getUrl();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/forex/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Forex forex = modules.getForex();
            if (null != forex){
                forex.setUrl(url);
                modules.setForex(forex);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
