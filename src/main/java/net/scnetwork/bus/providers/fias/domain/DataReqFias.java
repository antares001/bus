package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.domain.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqFias extends Data {

    @XmlElement(name = "fias")
    private FiasOptions fiasOptions;

    public FiasOptions getFiasOptions(){
        return fiasOptions;
    }

    public void setFiasOptions(FiasOptions fiasOptions){
        this.fiasOptions = fiasOptions;
    }
}
