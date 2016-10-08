package net.scnetwork.bus.config;

/**
 * Интерфейс настройки модулей
 */
public interface IModules {
    /**
     * Проверка на использование модуля
     * @return значение
     */
    boolean isUse();

    /**
     * Подключение/отключение модуля
     * @param use false - отключение, true - включение
     */
    void setUse(boolean use);
}
