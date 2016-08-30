package net.scnetwork.bus.rest;


import org.springframework.web.bind.annotation.RestController;

/**
 * Настройка модулей
 */
@RestController
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
    boolean setUse(boolean use);
}
