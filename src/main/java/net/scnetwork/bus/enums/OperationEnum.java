package net.scnetwork.bus.enums;

public enum OperationEnum {
    CHECK("check"),
    PAY("pay");

    private String name;

    OperationEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
