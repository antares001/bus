package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.domain.Response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response для сервиса ФИАС
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class ResponseFias extends Response{
    @XmlElement(name = "Data")
    private DataRespFias data;

    @Override
    public DataRespFias getData() {
        return data;
    }

    /**
     * Запись Data для ответа сервиса ФИАС
     * @param data структура Data
     */
    public void setData(DataRespFias data) {
        this.data = data;
    }
}
