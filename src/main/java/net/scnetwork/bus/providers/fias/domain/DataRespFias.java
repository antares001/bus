package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespFias extends Data{

    @XmlElement(name = "params")
    private List<ParamFias> paramList;

    public DataRespFias(){
        setService(ServiceEnum.FIAS);
        setDate(new Date());
    }

    public List<ParamFias> getParamList() {
        return paramList;
    }

    public void setParamList(List<ParamFias> paramList) {
        this.paramList = paramList;
    }
}
