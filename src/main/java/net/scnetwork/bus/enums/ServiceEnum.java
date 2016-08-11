package net.scnetwork.bus.enums;

public enum ServiceEnum {
    BPAY("bpay"),
    IDC("idc"),
    LEADER("leader"),
    FOREX("fix"),
    QIWI("qiwi"),
    MTS("mts"),
    BEELINE("beeline"),
    MEGAFON("megafon"),
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
