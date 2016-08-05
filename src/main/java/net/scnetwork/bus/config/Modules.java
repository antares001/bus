package net.scnetwork.bus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "modules")
public class Modules {
    private boolean artosis;
    private boolean idc;
    private boolean yandex;
    private boolean qiwi;
    private boolean leader;

    public Modules(){}

    public boolean isArtosis() {
        return artosis;
    }

    public void setArtosis(boolean artosis) {
        this.artosis = artosis;
    }

    public boolean isIdc() {
        return idc;
    }

    public void setIdc(boolean idc) {
        this.idc = idc;
    }

    public boolean isYandex() {
        return yandex;
    }

    public void setYandex(boolean yandex) {
        this.yandex = yandex;
    }

    public boolean isQiwi() {
        return qiwi;
    }

    public void setQiwi(boolean qiwi) {
        this.qiwi = qiwi;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    public String toString(){
        return "Modules:" +
                "{artosis:" + artosis + "}," +
                "{idc:" + idc + "}," +
                "{yandex:" + yandex + "}," +
                "{qiwi:" + qiwi + "}," +
                "{leader:" + leader + "}";
    }
}
