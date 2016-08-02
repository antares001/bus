package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.OperationEnum;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.operation.YandexOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class Data {
    @XmlAttribute(name = "status")
    private StatusEnum status;

    @XmlAttribute(name = "operation")
    private OperationEnum operation;

    @XmlAttribute(name = "yandex_operation")
    private YandexOperation yandexOperation;

    @XmlAttribute(name = "description")
    private String description;

    @XmlAttribute(name = "account")
    private String account;

    @XmlAttribute(name = "date")
    private Date date;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public OperationEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public YandexOperation getYandexOperation() {
        return yandexOperation;
    }

    public void setYandexOperation(YandexOperation yandexOperation) {
        this.yandexOperation = yandexOperation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
