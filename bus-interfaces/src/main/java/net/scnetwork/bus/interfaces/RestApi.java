package net.scnetwork.bus.rest;

/**
 * Настройка модулей
 */
public interface RestApi {

    /**
     * Роутер для получения информации
     * @param parameter параметр
     * @return данные
     */
    String getApi(String parameter);

    /**
     * Получение информации по конфигурации
     * @return конфигурация
     */
    String getConfig();

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
}
