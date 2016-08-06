package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.operation.BPayOperation;
import net.scnetwork.bus.providers.Bpay.BPayMethod;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

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

    public BPayOperation getOperation() {
        return operation;
    }

    public void setOperation(BPayOperation operation) {
        this.operation = operation;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BPayMethod getMethod() {
        return method;
    }

    public void setMethod(BPayMethod method) {
        this.method = method;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
