package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.domain.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Структура входящего сообщения для ФИАС
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public class RequestFias extends Request{
    @XmlElement(name = "Data")
    private DataReqFias data;

    @Override
    public DataReqFias getData() {
        return data;
    }

    /**
     * Запись структуры Data для сервиса ФИАС
     * @param data структура ФИАС
     */
    public void setData(DataReqFias data) {
        this.data = data;
    }
}
