package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.domain.DataRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data XML запроса сервиса bpay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqFias extends DataRequest {
    @XmlElement(name = "fias")
    private FiasOptions options;

    /**
     * Получение опций сервиса
     * @return опции
     */
    public FiasOptions getFiasOptions() {
        return options;
    }

    /**
     * Запись опций сервиса
     * @param options опции
     */
    public void setFiasOptions(FiasOptions options) {
        this.options = options;
    }
}
