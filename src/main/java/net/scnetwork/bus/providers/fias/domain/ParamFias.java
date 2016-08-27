package net.scnetwork.bus.providers.fias.domain;

import javax.xml.bind.annotation.*;

/**
 * Данные от сервиса ФИАС
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "url")
public class ParamFias {
    @XmlAttribute(name = "url")
    private String url;

    @XmlAttribute(name = "id")
    private int id;

    /**
     * Адрес файла
     * @return адрес
     */
    public String getUrl() {
        return url;
    }

    /**
     * Запись адреса файла
     * @param url адрес
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Идентификатор файла
     * @return идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Запись идентификатора файла
     * @param id идентификатор
     */
    public void setId(int id) {
        this.id = id;
    }
}
