package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.domain.DataRequest;
import net.scnetwork.bus.enums.OperationEnum;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqFias implements DataRequest {

    @XmlAttribute(name = "date")
    private Date date;

    @XmlAttribute(name = "account")
    private String account;

    @XmlAttribute(name = "operation")
    private OperationEnum operation;

    @XmlElement(name = "fias")
    private FiasOptions options;

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

    public FiasOptions getFiasOptions() {
        return options;
    }

    public void setFiasOptions(FiasOptions options) {
        this.options = options;
    }
}
