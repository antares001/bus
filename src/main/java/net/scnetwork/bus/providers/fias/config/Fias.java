package net.scnetwork.bus.providers.fias.config;

import net.scnetwork.bus.config.IModulesStandard;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса FIAS
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "fias")
public class Fias implements IModulesStandard {
    private boolean use;
    private String service;
    private String url;
    private String format;
    private MongoConfig mongoconfig;

    public static final String DESRIPTION = "ФИАС";

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public MongoConfig getMongoconfig() {
        return mongoconfig;
    }

    public void setMongoconfig(MongoConfig mongoconfig) {
        this.mongoconfig = mongoconfig;
    }

    @Override
    public String toString(){
        return "FIAS:{use:" + use + ",service:" + service + ",url:" + url + "}";
    }
}
