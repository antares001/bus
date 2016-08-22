package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.providers.yandex.enums.YandexOperation;

/**
 * Дополнительные опции сервиса Yandex
 */
public class YandexOptions {
    private YandexOperation operation;

    /**
     * Получение опций
     * @return опции
     */
    public YandexOperation getOperation() {
        return operation;
    }

    /**
     * Запись опций
     * @param operation опция
     */
    public void setOperation(YandexOperation operation) {
        this.operation = operation;
    }
}
