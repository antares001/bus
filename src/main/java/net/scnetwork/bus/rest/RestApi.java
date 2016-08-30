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
}
