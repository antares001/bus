package net.scnetwork.bus.providers.megafon.domain;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespMegafon extends Data{
    public DataRespMegafon(){
        setService(ServiceEnum.MEGAFON);
        setDate(new Date());
    }
}