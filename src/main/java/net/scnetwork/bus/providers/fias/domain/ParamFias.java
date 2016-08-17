package net.scnetwork.bus.providers.fias.domain;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "url")
public class ParamFias {
    @XmlAttribute
    private String url;

    @XmlAttribute
    private int id;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
