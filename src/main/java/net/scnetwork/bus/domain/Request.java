package net.scnetwork.bus.domain;

import javax.xml.bind.annotation.*;

/**
 * Запрос XML
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public abstract class Request {
    @XmlAttribute(name = "type")
    private int type;

    @XmlElement(name = "Auth")
    private Auth auth;

    @XmlElement(name = "Data")
    private Data data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
