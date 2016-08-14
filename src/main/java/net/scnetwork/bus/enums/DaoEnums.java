package net.scnetwork.bus.enums;

/**
 * Типы подключения к БД
 */
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

    public String toString(){
        return this.getName();
    }
}
