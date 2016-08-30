package net.scnetwork.bus.providers.yandex.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Настройка модуля yandex
 */
public class YandexRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/yandex/get/info")
    @Override
    public String getConfig() {
        return null;
    }
}
