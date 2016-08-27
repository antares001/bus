package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.domain.DataRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * XML Data запроса
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqYandex extends DataRequest {
    @XmlElement(name = "yandex")
    private YandexOptions yandexOptions;

    public YandexOptions getYandexOptions(){
        return yandexOptions;
    }

    public void setYandexOptions(YandexOptions yandexOptions){
        this.yandexOptions = yandexOptions;
    }

}
