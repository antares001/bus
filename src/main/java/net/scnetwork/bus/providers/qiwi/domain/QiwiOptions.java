package net.scnetwork.bus.providers.qiwi.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Опции сервиса qiwi
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "QiwiOptions")
public class QiwiOptions {
    @XmlAttribute(name = "operation")
    private String operation;

    /**
     * Опция: операция
     * @return операция
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Запись опции: операция
     * @param operation операция
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }
}
