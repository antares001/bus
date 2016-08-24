package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.domain.DataRequest;
import net.scnetwork.bus.enums.OperationEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * XML Data запроса
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqYandex extends DataRequest {
    @XmlElement(name = "yandex")
    private YandexOptions yandexOptions;

    @XmlElement(name = "date")
    private Date date;

    @XmlElement(name = "account")
    private String account;

    @XmlElement(name = "operation")
    private OperationEnum operation;

    public YandexOptions getYandexOptions(){
        return yandexOptions;
    }

    public void setYandexOptions(YandexOptions yandexOptions){
        this.yandexOptions = yandexOptions;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public OperationEnum getOperation() {
        return operation;
    }

    @Override
    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }
}
