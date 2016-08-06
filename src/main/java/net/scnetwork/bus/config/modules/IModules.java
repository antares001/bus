package net.scnetwork.bus.config.modules;

import net.scnetwork.bus.enums.UseEnum;

public interface IModules {

    boolean isUse();

    void setUse(boolean use);

    UseEnum getUseEnum();

    void setUseEnum(UseEnum useEnum);

    String getUrl();

    void setUrl(String url);
}
