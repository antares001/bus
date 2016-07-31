package net.scnetwork.bus.enums;

public enum ServiceEnum {
    ARTOSIS("artosis"),
    IDC("idc"),
    LEADER("leader"),
    FOREX("fix");

    private String name;

    ServiceEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
