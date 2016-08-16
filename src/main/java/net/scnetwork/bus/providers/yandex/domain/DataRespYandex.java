package net.scnetwork.bus.providers.yandex.domain;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespYandex extends Data{
    public DataRespYandex(){
        setService(ServiceEnum.YANDEX);
        setDate(new Date());
    }
}
