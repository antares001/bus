package net.scnetwork.bus.providers.forex.config;

import net.scnetwork.bus.config.IModulesStandard;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса Forex
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "forex")
public class Forex implements IModulesStandard{
    private boolean use;
    private String service;
    private String url;
    private String point;
    private String client;
    private int timeout;

    public static final String DESCRIPTION = "Forex";

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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString(){
        return "Forex:{use:" + use +
                ",service:" + service +
                ",url:" + url +
                ", point:" + point +
                ", client:" + client +
                ", timeout:" + timeout + "}";
    }
}
