package net.scnetwork.bus.providers.beeline.domain;


import net.scnetwork.bus.domain.Response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response для сервиса Beeline
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class ResponseBeeline extends Response{
    @XmlElement(name = "Data")
    private DataRespBeeline data;

    @Override
    public DataRespBeeline getData() {
        return data;
    }

    /**
     * Запись Data для ответа сервиса Beeline
     * @param data структура Data
     */
    public void setData(DataRespBeeline data) {
        this.data = data;
    }
}
