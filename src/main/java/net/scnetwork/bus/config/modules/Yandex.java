package net.scnetwork.bus.config.modules;

import net.scnetwork.bus.enums.UseEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "yandex")
public class Yandex {
    private boolean use;
    private UseEnum useEnum;
    private String url;

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public UseEnum getUseEnum() {
        return useEnum;
    }

    public void setUseEnum(UseEnum useEnum) {
        this.useEnum = useEnum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
