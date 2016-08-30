package net.scnetwork.bus.providers.jpos.service;

import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Настройка модуля Jpos
 */
public class JposRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/jpos/gt/info")
    @Override
    public String getConfig() {
        return null;
    }
}
