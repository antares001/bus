package net.scnetwork.bus.providers.yandex.config;

import net.scnetwork.bus.config.IModules;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса Yandex
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "yandex")
public class Yandex implements IModules {
    private boolean use;
    private String service;
    private String url;
    private boolean soap;

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean isSoap() {
        return soap;
    }

    @Override
    public void setSoap(boolean soap) {
        this.soap = soap;
    }
}
