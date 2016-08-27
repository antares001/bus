package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.domain.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public class RequestYandex extends Request{
    @XmlElement(name = "Data")
    private DataReqYandex data;

    @Override
    public DataReqYandex getData() {
        return data;
    }

    public void setData(DataReqYandex data) {
        this.data = data;
    }
}
