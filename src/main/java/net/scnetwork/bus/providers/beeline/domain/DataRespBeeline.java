package net.scnetwork.bus.providers.beeline.domain;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Формирование секции XML Data для сервиса Beeline
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespBeeline extends Data {
    public DataRespBeeline(){
        setService(ServiceEnum.BEELINE);
        setDate(new Date());
    }
}
