package net.scnetwork.bus.domain;

import net.scnetwork.bus.providers.Fias.FiasOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = " fias")
public class FiasOptions {
    @XmlAttribute
    private FiasOperation fiasOperation;

    public FiasOperation getFiasOperation() {
        return fiasOperation;
    }

    public void setFiasOperation(FiasOperation fiasOperation) {
        this.fiasOperation = fiasOperation;
    }
}
