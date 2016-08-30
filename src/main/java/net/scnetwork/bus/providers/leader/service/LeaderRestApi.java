package net.scnetwork.bus.providers.leader.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * Настройка модуля Лидер
 */
public class LeaderRestApi implements RestApi{
    @RequestMapping(value = "/rest/api/modules/leader/get/info")
    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
                return leader.toString();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
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

    @RequestMapping(value = "/rest/api/modules/leader/get/use")
    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
                return leader.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
                leader.setUse(use);
                modules.setLeader(leader);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
