package net.scnetwork.bus.enums;

/**
 * Тип обработки сервисов
 */
public enum UseEnum {
    LOCAL("local"),
    REMOTE("remote");

    private String name;

    UseEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
