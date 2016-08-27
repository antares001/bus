package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.providers.yandex.enums.YandexOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Дополнительные опции сервиса Yandex
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "YandexOption")
public class YandexOptions {
    @XmlAttribute(name = "operation")
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
