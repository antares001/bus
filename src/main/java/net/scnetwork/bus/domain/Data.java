package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.OperationEnum;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class Data {
    @XmlAttribute(name = "status")
    private StatusEnum status;

    @XmlAttribute(name = "service")
    private ServiceEnum service;

    @XmlAttribute
    private String result;

    @XmlAttribute(name = "operation")
    private OperationEnum operation;

    @XmlElement(name = "yandex")
    private YandexOptions yandexOptions;

    @XmlElement(name = "fias")
    private FiasOptions fiasOptions;

    @XmlAttribute(name = "description")
    private String description;

    @XmlAttribute(name = "account")
    private String account;

    @XmlAttribute(name = "date")
    private Date date;

    @XmlElement(name = "bpay")
    private BPayOptions bPayOptions;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public ServiceEnum getService() {
        return service;
    }

    public void setService(ServiceEnum service) {
        this.service = service;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public BPayOptions getbPayOptions() {
        return bPayOptions;
    }

    public void setbPayOptions(BPayOptions bPayOptions) {
        this.bPayOptions = bPayOptions;
    }

    public FiasOptions getFiasOptions() {
        return fiasOptions;
    }

    public void setFiasOptions(FiasOptions fiasOptions) {
        this.fiasOptions = fiasOptions;
    }

    public YandexOptions getYandexOptions() {
        return yandexOptions;
    }

    public void setYandexOptions(YandexOptions yandexOptions) {
        this.yandexOptions = yandexOptions;
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
