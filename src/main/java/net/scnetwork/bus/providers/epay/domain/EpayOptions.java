package net.scnetwork.bus.providers.epay.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Опции сервиса epay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "epay")
public class EpayOptions {
    @XmlAttribute(name = "operation")
    private String operation;

    /**
     * Тип операции на стороне сервиса
     * @return тип
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Запись типа операции
     * @param operation тип
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
