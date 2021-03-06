package net.scnetwork.bus.providers.yandex.config;

import net.scnetwork.bus.config.IModulesStandard;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса Yandex
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "yandex")
public class Yandex implements IModulesStandard {
    private boolean use;
    private String service;
    private String url;

    public static final String DESCRIPTION = "Yandex";

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
        return "Yandex:{use:" + use + ",service:" + service + ",url:" + url + "}";
    }
}
