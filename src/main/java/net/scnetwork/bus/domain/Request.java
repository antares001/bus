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

    /**
     * Получение типа запроса
     * @return тип
     */
    public int getType() {
        return type;
    }

    /**
     * Запись типа запроса
     * @param type тип
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Плоучение модуля авторизации
     * @return модуль авторизации
     */
    public Auth getAuth() {
        return auth;
    }

    /**
     * Запись модуля авторизации
     * @param auth модуль авторизации
     */
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    /**
     * Получение модуля Data
     * @return модуль Data
     */
    public Data getData() {
        return data;
    }

    /**
     * Запись модуля Data
     * @param data модуль Data
     */
    public void setData(Data data) {
        this.data = data;
    }
}
