package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.providers.bpay.enums.BPayOperation;
import net.scnetwork.bus.providers.bpay.enums.BPayMethod;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Формирование секции bpay XML
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bpay")
public class BPayOptions {
    @XmlAttribute(name = "operation")
    private BPayOperation operation;

    @XmlAttribute(name = "amount")
    private BigDecimal amount;

    @XmlAttribute(name = "description")
    private String description;

    @XmlAttribute(name = "method")
    private BPayMethod method;

    @XmlAttribute(name = "order")
    private String order;

    @XmlAttribute
    private int currency;

    /**
     * Получение типа операции bpay
     * @return тип
     */
    public BPayOperation getOperation() {
        return operation;
    }

    /**
     * Запись типа операции bpay
     * @param operation тип
     */
    public void setOperation(BPayOperation operation) {
        this.operation = operation;
    }

    /**
     * Получение суммы
     * @return сумма
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Запись суммы
     * @param amount сумма
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Получение описания
     * @return описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Запись описания
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получение метода
     * @return метод
     */
    public BPayMethod getMethod() {
        return method;
    }

    /**
     * Запись метода
     * @param method метод
     */
    public void setMethod(BPayMethod method) {
        this.method = method;
    }

    /**
     * Получение order
     * @return order
     */
    public String getOrder() {
        return order;
    }

    /**
     * Запись order
     * @param order order
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * Получение валюты
     * @return валюта
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * Запись валюты
     * @param currency валюта
     */
    public void setCurrency(int currency) {
        this.currency = currency;
    }
}
