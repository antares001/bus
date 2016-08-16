package net.scnetwork.bus.config;

import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.idc.config.Idc;
import net.scnetwork.bus.providers.jpos.config.Jpos;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.providers.qiwi.config.Qiwi;
import net.scnetwork.bus.providers.yandex.config.Yandex;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация модулей
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "modules")
public class Modules {
    private BPay bpay;
    private Idc idc;
    private Yandex yandex;
    private Qiwi qiwi;
    private Leader leader;
    private Jpos jpos;

    public Modules(){}

    public BPay getBpay() {
        return bpay;
    }

    public void setBpay(BPay bpay) {
        this.bpay = bpay;
    }

    public Idc getIdc() {
        return idc;
    }

    public void setIdc(Idc idc) {
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

    public Jpos getJpos() {
        return jpos;
    }

    public void setJpos(Jpos jpos) {
        this.jpos = jpos;
    }

    public String toString(){
        return "Modules:" +
                "{bpay:" + bpay.toString() + "}," +
                "{idc:" + idc + "}," +
                "{yandex:" + yandex.toString() + "}," +
                "{qiwi:" + qiwi + "}," +
                "{leader:" + leader + "}" +
                "{jpos:" + jpos + "}";
    }
}
