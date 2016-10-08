package net.scnetwork.bus.enums;

/**
 * Типы сервисов
 */
public enum ServiceEnum {
    BPAY("bpay"),
    EPAY("epay"),
    LEADER("leader"),
    FOREX("fix"),
    QIWI("qiwi"),
    YANDEX("yandex"),
    FIAS("fias");

    private String name;

    ServiceEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
