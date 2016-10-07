package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Настройка модуля ФИАС
 */
@RestController
public class FiasRestApi implements RestApiStandard {
    @Autowired
    private Fias config;

    @RequestMapping(value = "/rest/modules/fias/operation")
    public String operation(@QueryParam(value = "type") String type){
        return type;
    }

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
