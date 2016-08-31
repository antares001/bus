package net.scnetwork.bus.providers.leader.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Настройка модуля Лидер
 */
@RestController
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

    @RequestMapping(value = "/rest/api/modules/leader/get/service")
    @Override
    public String getService() {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
                return leader.getService();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/service")
    @Override
    public boolean setService(@RequestParam(value = "service") String service) {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
                leader.setService(service.toUpperCase());
                modules.setLeader(leader);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/leader/get/service")
    @Override
    public String getUrl() {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
                return leader.getUrl();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/leader/set/url")
    @Override
    public boolean setUrl(@RequestParam(value = "url") String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Leader leader = modules.getLeader();
            if (null != leader){
                leader.setUrl(url);
                modules.setLeader(leader);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
