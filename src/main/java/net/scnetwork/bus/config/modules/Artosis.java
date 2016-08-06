package net.scnetwork.bus.config.modules;

import net.scnetwork.bus.enums.UseEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "idc")
public class Artosis implements IModules{
    private boolean use;
    private UseEnum useEnum;
    private String url;
    private String point;

    @Override
    public boolean isUse() {
        return use;
    }

    @Override
    public void setUse(boolean use) {
        this.use = use;
    }

    @Override
    public UseEnum getUseEnum() {
        return useEnum;
    }

    @Override
    public void setUseEnum(UseEnum useEnum) {
        this.useEnum = useEnum;
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
}
