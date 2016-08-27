package net.scnetwork.bus.providers.qiwi.domain;


import net.scnetwork.bus.domain.DataRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqQiwi extends DataRequest{
    @XmlElement(name = "QiwiOptions")
    private QiwiOptions options;

    public QiwiOptions getOptions() {
        return options;
    }

    public void setOptions(QiwiOptions options) {
        this.options = options;
    }
}
