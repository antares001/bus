package net.scnetwork.bus.providers.yandex.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.yandex.config.Yandex;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * Настройка модуля yandex
 */
public class YandexRestApi implements RestApi{
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
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/yandex/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/yandex/get/use")
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
        return false;
    }
}
