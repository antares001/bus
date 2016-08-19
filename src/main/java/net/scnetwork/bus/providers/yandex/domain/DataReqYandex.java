package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.domain.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqYandex extends Data {
    @XmlElement(name = "yandex")
    private YandexOptions yandexOptions;

    public YandexOptions getYandexOptions(){
        return yandexOptions;
    }

    public void setYandexOptions(YandexOptions yandexOptions){
        this.yandexOptions = yandexOptions;
    }
}