package net.scnetwork.bus.providers.jpos.service;

import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.jpos.config.Jpos;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * Настройка модуля Jpos
 */
@RestController
public class JposRestApi implements RestApiStandard {
    @Autowired
    private Jpos config;

    @RequestMapping(value = "/rest/api/modules/jpos/get/{parameter}")
    @Override
    public String getApi(@PathParam(value = "parameter") @NotNull String parameter) {
        switch (parameter) {
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
        if (null != config) {
            return config.toString();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @Override
    public boolean getUse() {
        return null != config && config.isUse();
    }

    @Override
    public String getService() {
        if (null != config) {
            return config.getService();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @Override
    public String getUrl() {
        if (null != config) {
            return config.getUrl();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }
}
