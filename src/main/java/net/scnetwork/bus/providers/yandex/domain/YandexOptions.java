package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.providers.yandex.enums.YandexOperation;

public class YandexOptions {
    private YandexOperation operation;

    public YandexOperation getOperation() {
        return operation;
    }

    public void setOperation(YandexOperation operation) {
        this.operation = operation;
    }
}
