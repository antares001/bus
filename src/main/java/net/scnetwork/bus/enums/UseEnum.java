package net.scnetwork.bus.enums;

/**
 * Тип обработки сервисов:
 * <ol>
 *     <li>LOCAL - внутренняя реализация</li>
 *     <li>REMOTE - использование внешнего микросервиса</li>
 * </ol>
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
