package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.domain.DataRequest;
import net.scnetwork.bus.enums.OperationEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Структура секции Data запроса к сервису BPay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqBpay implements DataRequest{
    @XmlElement(name = "account")
    private String account;

    @XmlElement(name = "date")
    private Date date;

    @XmlElement(name = "operation")
    private OperationEnum operation;

    @XmlElement(name = "bpay")
    private BPayOptions bPayOptions;

    public BPayOptions getbPayOptions(){
        return bPayOptions;
    }

    public void setbPayOptions(BPayOptions bPayOptions){
        this.bPayOptions = bPayOptions;
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

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }
}
