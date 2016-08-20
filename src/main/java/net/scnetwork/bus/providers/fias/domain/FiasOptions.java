package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.providers.fias.enums.FiasFormatEnum;
import net.scnetwork.bus.providers.fias.enums.FiasOperation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Дополнительная секция
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = " fias")
public class FiasOptions {
    @XmlAttribute
    private FiasOperation fiasOperation;

    @XmlAttribute
    private FiasFormatEnum formatEnum;

    public FiasOperation getFiasOperation() {
        return fiasOperation;
    }

    public void setFiasOperation(FiasOperation fiasOperation) {
        this.fiasOperation = fiasOperation;
    }

    public FiasFormatEnum getFormatEnum() {
        return formatEnum;
    }

    public void setFormatEnum(FiasFormatEnum formatEnum) {
        this.formatEnum = formatEnum;
    }
}
