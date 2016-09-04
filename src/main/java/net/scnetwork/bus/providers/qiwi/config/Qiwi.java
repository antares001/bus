package net.scnetwork.bus.providers.qiwi.config;

import net.scnetwork.bus.config.IModulesStandard;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса QIWI
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "qiwi")
public class Qiwi implements IModulesStandard {
    private boolean use;
    private String service;
    private String url;

    public static final String DESCRIPTION = "Qiwi";

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

    @Override
    public String toString(){
        return "Qiwi:{use:" + use + ",service:" + service + ",url:" + url + "}";
    }
}
