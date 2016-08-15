package net.scnetwork.bus.domain;

import javax.xml.bind.annotation.*;

/**
 * Ответ XML
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class Response {
    @XmlAttribute(name = "type")
    private int type;

    @XmlElement(name = "Data")
    private Data data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
