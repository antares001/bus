package net.scnetwork.bus.enums;

public enum DaoEnums {
    ORACLE("oracle"),
    ORACLE_POOL("oracle_pool"),
    POSTGRESQL("postgresql");

    private String name;

    DaoEnums(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
