package net.scnetwork.bus.rest;

/**
 * Настройка стандартных модулей
 */
public interface RestApiStandard extends RestApi{
    /**
     * Запись настроек
     * @param use признак использования
     * @param service тип сервиса (локальный, микросервис)
     * @param url адрес микросервиса
     * @return результат операции
     */
    boolean setConfig(Boolean use, String service, String url);

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
