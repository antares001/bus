package net.scnetwork.bus.config;

import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.forex.config.Forex;
import net.scnetwork.bus.providers.jpos.config.Jpos;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.providers.print.config.Print;
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
    private Yandex yandex;
    private Qiwi qiwi;
    private Leader leader;
    private Jpos jpos;
    private Fias fias;
    private Print print;
    private Forex forex;

    /**
     * Инициализация
     */
    public Modules(){
        bpay = new BPay();
        yandex = new Yandex();
        qiwi = new Qiwi();
        leader = new Leader();
        jpos = new Jpos();
        fias = new Fias();
        print = new Print();
        forex = new Forex();
    }

    /**
     * Получение настроек bpay
     * @return настройки
     */
    public BPay getBpay() {
        return bpay;
    }

    /**
     * Запись настроек bpay
     * @param bpay настройки
     */
    public void setBpay(BPay bpay) {
        this.bpay = bpay;
    }

    /**
     * Получение настроек yandex
     * @return настройки
     */
    public Yandex getYandex() {
        return yandex;
    }

    /**
     * Запись настроек yandex
     * @param yandex настройки
     */
    public void setYandex(Yandex yandex) {
        this.yandex = yandex;
    }

    /**
     * Получение настроек qiwi
     * @return настройки
     */
    public Qiwi getQiwi() {
        return qiwi;
    }

    /**
     * Запись настроек qiwi
     * @param qiwi настройки
     */
    public void setQiwi(Qiwi qiwi) {
        this.qiwi = qiwi;
    }

    /**
     * Получение настроек Лидер
     * @return настройки
     */
    public Leader getLeader() {
        return leader;
    }

    /**
     * Запись настроек Лидер
     * @param leader настройки
     */
    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    /**
     * Получение настроек jpos
     * @return настройки
     */
    public Jpos getJpos() {
        return jpos;
    }

    /**
     * Запись настроек jpos
     * @param jpos настройки
     */
    public void setJpos(Jpos jpos) {
        this.jpos = jpos;
    }

    /**
     * Получение настроек ФИАС
     * @return настройки
     */
    public Fias getFias() {
        return fias;
    }

    /**
     * Запись настроек ФИАС
     * @param fias настройки
     */
    public void setFias(Fias fias) {
        this.fias = fias;
    }

    /**
     * Получение настроек генерации pdf
     * @return настройки
     */
    public Print getPrint() {
        return print;
    }

    /**
     * Запись настроек генерации pdf
     * @param print настройки
     */
    public void setPrint(Print print) {
        this.print = print;
    }

    /**
     * Получение настроек Forex
     * @return настройки
     */
    public Forex getForex() {
        return forex;
    }

    /**
     * Получение настроек Forex
     * @param forex настройки
     */
    public void setForex(Forex forex) {
        this.forex = forex;
    }

    /**
     * Приведение объекта к строке
     * @return строка
     */
    @Override
    public String toString(){
        return "Modules:{" +
                "bpay:{" + bpay.toString() +
                "},yandex{:" + yandex.toString() +
                "},qiwi:{" + qiwi.toString() +
                "},leader:{" + leader.toString() +
                "},jpos:{" + jpos.toString() +
                "},fias:{" + fias.toString() +
                "},print:{" + print.toString()+
                "},forex:{" + forex.toString() + "}}";
    }
}
