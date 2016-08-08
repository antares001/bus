package net.scnetwork.bus.enums;

public enum UseEnum {
    LOCAL("local"),
    REMOTE("remote"),
    NONE("none");

    private String name;

    UseEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
