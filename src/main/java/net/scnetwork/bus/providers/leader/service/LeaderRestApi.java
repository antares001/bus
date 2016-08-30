package net.scnetwork.bus.providers.leader.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Настройка модуля Лидер
 */
public class LeaderRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/leader/get/info")
    @Override
    public String getConfig() {
        return null;
    }
}
