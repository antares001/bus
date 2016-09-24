package net.scnetwork.bus.rest;

/**
 * Настройка стандартных модулей
 */
public interface RestApiStandard extends RestApi{
    /**
     * Тип сервиса
     * @return тип
     */
    String getService();

    /**
     * Адрес микросервиса
     * @return адрес
     */
    String getUrl();
}
