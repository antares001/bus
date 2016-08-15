package net.scnetwork.bus.domain.DataResponse;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespIdc extends Data{
    public DataRespIdc(){
        setService(ServiceEnum.IDC);
        setDate(new Date());
    }
}
