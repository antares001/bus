package net.scnetwork.bus.providers.qiwi.domain;


import net.scnetwork.bus.domain.DataRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Формирование структуры Data для сервиса Qiwi
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqQiwi extends DataRequest{
    @XmlElement(name = "QiwiOptions")
    private QiwiOptions options;

    /**
     * Получение опций для сервиса qiwi
     * @return опции
     */
    public QiwiOptions getOptions() {
        return options;
    }

    /**
     * Запись опций для сервиса qiwi
     * @param options опции
     */
    public void setOptions(QiwiOptions options) {
        this.options = options;
    }
}
