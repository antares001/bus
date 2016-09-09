package net.scnetwork.bus.interfaces;

/**
 * Стандартная конфигурация
 */
public interface IModulesStandard extends IModules{
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
