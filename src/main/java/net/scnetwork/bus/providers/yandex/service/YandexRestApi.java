package net.scnetwork.bus.providers.yandex.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.yandex.config.Yandex;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * Настройка модуля yandex
 */
@RestController
public class YandexRestApi implements RestApiStandard{
    @RequestMapping(value = "/rest/api/modules/yandex/get/{parameter}")
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

    @RequestMapping(value = "/rest/api/modules/yandex/get/info")
    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            Yandex yandex = modules.getYandex();
            if (null != yandex) {
                return yandex.toString();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Yandex yandex = modules.getYandex();
            if (null != yandex){
                yandex.setUse(use);
                yandex.setService(service.toUpperCase());
                yandex.setUrl(url);

                modules.setYandex(yandex);
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
            Yandex yandex = modules.getYandex();
            if (null != yandex){
                return yandex.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/yandex/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules){
            Yandex yandex = modules.getYandex();
            if (null != yandex){
                yandex.setUse(use);
                modules.setYandex(yandex);
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
            Yandex yandex = modules.getYandex();
            if (null != yandex){
                return yandex.getService();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/yandex/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules){
            Yandex yandex = modules.getYandex();
            if (null != yandex){
                yandex.setService(service.toUpperCase());
                modules.setYandex(yandex);
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
            Yandex yandex = modules.getYandex();
            if (null != yandex){
                return yandex.getUrl();
            }
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @RequestMapping(value = "/rest/api/modules/yandex/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Yandex yandex = modules.getYandex();
            if (null != yandex){
                yandex.setUrl(url);
                modules.setYandex(yandex);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
