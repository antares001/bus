package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.domain.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public class RequestBpay extends Request{
    @XmlElement(name = "Data")
    private DataReqBpay data;

    @Override
    public DataReqBpay getData() {
        return data;
    }

    public void setData(DataReqBpay data) {
        this.data = data;
    }
}
