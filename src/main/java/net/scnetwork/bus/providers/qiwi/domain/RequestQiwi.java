package net.scnetwork.bus.providers.qiwi.domain;

import net.scnetwork.bus.domain.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public class RequestQiwi extends Request{
    @XmlElement(name = "Data")
    private DataReqQiwi data;

    public DataReqQiwi getData() {
        return data;
    }

    public void setData(DataReqQiwi data) {
        this.data = data;
    }
}
