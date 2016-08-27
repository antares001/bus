package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.providers.beeline.domain.DataRespBeeline;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response для сервиса Bpay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class ResponseBpay  extends Response{
    @XmlElement(name = "Data")
    private DataRespBeeline data;

    @Override
    public DataRespBeeline getData() {
        return data;
    }

    /**
     * Запись Data для ответа сервиса Bpay
     * @param data структура Data
     */
    public void setData(DataRespBeeline data) {
        this.data = data;
    }
}
