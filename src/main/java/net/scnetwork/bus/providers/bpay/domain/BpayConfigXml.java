package net.scnetwork.bus.providers.bpay.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ответ для REST API сервиса bpay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bpay")
public class BpayConfigXml {
    @XmlElement(name = "use")
    private boolean use;

    @XmlElement(name = "service")
    private String service;

    @XmlElement(name = "url")
    private String url;

    /**
     * Признак использования
     * @return признак
     */
    public boolean isUse() {
        return use;
    }

    /**
     * Запись признака использования
     * @param use признак
     */
    public void setUse(boolean use) {
        this.use = use;
    }

    /**
     * Тип сервиса
     * @return тип
     */
    public String getService() {
        return service;
    }

    /**
     * Щапись типа сервиса
     * @param service тип
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * Адрес микросервиса
     * @return адрес
     */
    public String getUrl() {
        return url;
    }

    /**
     * Запись адреса микросервиса
     * @param url адрес
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
