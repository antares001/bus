package net.scnetwork.bus.config.modules;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "modules")
public class Modules {
    private boolean artosis;
    private boolean idc;
    private Yandex yandex;
    private Qiwi qiwi;
    private Leader leader;

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

    public Yandex getYandex() {
        return yandex;
    }

    public void setYandex(Yandex yandex) {
        this.yandex = yandex;
    }

    public Qiwi getQiwi() {
        return qiwi;
    }

    public void setQiwi(Qiwi qiwi) {
        this.qiwi = qiwi;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public String toString(){
        return "Modules:" +
                "{artosis:" + artosis + "}," +
                "{idc:" + idc + "}," +
                "{yandex:" + yandex.toString() + "}," +
                "{qiwi:" + qiwi + "}," +
                "{leader:" + leader + "}";
    }
}
