package net.scnetwork.bus.providers.epay.domain;

import net.scnetwork.bus.domain.DataRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Структура секции Data запроса к сервису ePay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqEpay extends DataRequest{
    @XmlElement(name = "epay")
    private EpayOptions options;

    /**
     * Опиции сервиса
     * @return опции
     */
    public EpayOptions getOptions() {
        return options;
    }

    /**
     * Запись опций сервиса
     * @param options опции
     */
    public void setOptions(EpayOptions options) {
        this.options = options;
    }
}
