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

    /**
     * Получение типа
     * @return тип
     */
    public int getType() {
        return type;
    }

    /**
     * Запись типа
     * @param type тип
     */
    public void setType(int type) {
        this.type = type;
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
