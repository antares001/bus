package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.domain.DataResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Формирование секции Data ответа сервиса BPay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespBpay extends DataResponse{
    @XmlAttribute(name = "bpay_response")
    private String bpayResponse;

    /**
     * Ответ от bpay
     * @return ответ
     */
    public String getBpayResponse() {
        return bpayResponse;
    }


    /**
     * Запись ответа от bpay
     * @param bpayResponse ответ
     */
    public void setBpayResponse(String bpayResponse) {
        this.bpayResponse = bpayResponse;
    }
}
