package net.scnetwork.bus.rest;

/**
 * Настройка модулей
 */
public interface RestApi {
    /**
     * Получение информации по конфигурации
     * @return конфигурация
     */
    String getConfig();

    /**
     * Запись настроек
     * @param use признак использования
     * @param service тип сервиса (локальный, микросервис)
     * @param url адрес микросервиса
     * @return результат операции
     */
    boolean setConfig(Boolean use, String service, String url);

    /**
     * Получение признака
     * @return признак
     */
    boolean getUse();

    /**
     * Установка признака
     * @param use признак
     * @return успешность операции
     */
    boolean setUse(Boolean use);

    /**
     * Тип сервиса
     * @return тип
     */
    String getService();

    /**
     * Запись типа сервиса
     * @param service тип
     * @return результат выполнения
     */
    boolean setService(String service);

    /**
     * Адрес микросервиса
     * @return адрес
     */
    String getUrl();

    /**
     * Запись адреса микросервиса
     * @param url адрес
     * @return результат выполнения операции
     */
    boolean setUrl(String url);
}
