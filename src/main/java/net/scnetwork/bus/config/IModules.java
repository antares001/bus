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

    /**
     * Получение типа сервиса
     * @return тип сервиса
     */
    String getService();

    /**
     * Установка типа сервиса
     * @param service тип сервиса (LOCAL - шина, REMOTE - микросервис)
     */
    void setService(String service);

    /**
     * Получение адрес микросервиса
     * @return адрес
     */
    String getUrl();

    /**
     * Установка адреса микросервиса
     * @param url адрес (для service: LOCAL -> usl: none)
     */
    void setUrl(String url);
}
