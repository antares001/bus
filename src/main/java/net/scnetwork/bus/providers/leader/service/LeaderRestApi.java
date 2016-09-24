package net.scnetwork.bus.providers.leader.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.rest.RestApiStandard;
import net.scnetwork.bus.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

/**
 * Настройка модуля Лидер
 */
@RestController
public class LeaderRestApi implements RestApiStandard {
    @Autowired
    private Leader leader;

    @RequestMapping(value = "/rest/modules/leader/get/{parameter}")
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
        if (null != leader) {
            return leader.toString();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Leader leader = modules.getLeader();
            if (null != leader) {
                leader.setUse(use);
                leader.setService(service.toUpperCase());
                leader.setUrl(url);

                modules.setLeader(leader);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getUse() {
        if (null != leader) {
            return leader.isUse();
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Leader leader = modules.getLeader();
            if (null != leader) {
                leader.setUse(use);
                modules.setLeader(leader);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getService() {
        if (null != leader) {
            return leader.getService();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Leader leader = modules.getLeader();
            if (null != leader) {
                leader.setService(service.toUpperCase());
                modules.setLeader(leader);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getUrl() {
        if (null != leader) {
            return leader.getUrl();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules) {
            Leader leader = modules.getLeader();
            if (null != leader) {
                leader.setUrl(url);
                modules.setLeader(leader);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
