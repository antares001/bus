package net.scnetwork.bus.providers.leader.config;

import net.scnetwork.bus.config.IModulesStandard;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса Лидер
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "leader")
public class Leader implements IModulesStandard {
    private boolean use;
    private String service;
    private String url;
    private String point;

    public static final String DESRIPTION = "Лидер";

    @Override
    public boolean isUse() {
        return use;
    }

    @Override
    public void setUse(boolean use) {
        this.use = use;
    }

    @Override
    public String getService() {
        return service;
    }

    @Override
    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString(){
        return "Leader:{use:" + use + ",service:" + service + ",url:" + url + "}";
    }
}
