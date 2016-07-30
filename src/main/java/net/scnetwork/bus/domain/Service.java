package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "service")
public class Service {
    @XmlAttribute
    private ServiceEnum value;

    public ServiceEnum getValue() {
        return value;
    }

    public void setValue(ServiceEnum value) {
        this.value = value;
    }
}
