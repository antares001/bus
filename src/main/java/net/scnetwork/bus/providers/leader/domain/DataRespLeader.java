package net.scnetwork.bus.providers.leader.domain;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespLeader implements DataResp{
    public DataRespLeader(){
        setService(ServiceEnum.LEADER);
        setDate(new Date());
    }
}
