package net.scnetwork.bus.domain;

import net.scnetwork.bus.providers.bpay.domain.DataRespBpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Response ошибки
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
public class ResponseError extends Response{
    @XmlAttribute(name = "Data")
    private DataRespBpay data;

    @Override
    public DataRespBpay getData() {
        return data;
    }

    /**
     * Запись Data для ошибки
     * @param data Data
     */
    public void setData(DataRespBpay data) {
        this.data = data;
    }
}
