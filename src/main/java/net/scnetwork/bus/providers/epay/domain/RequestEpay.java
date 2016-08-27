package net.scnetwork.bus.providers.epay.domain;

import net.scnetwork.bus.domain.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Структура запроса для сервиса epay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
public class RequestEpay extends Request{
    @XmlElement(name = "Data")
    private DataReqEpay data;

    @Override
    public DataReqEpay getData() {
        return data;
    }

    /**
     * Запись структуры Data для сервиса epay
     * @param data структура Data
     */
    public void setData(DataReqEpay data) {
        this.data = data;
    }
}
