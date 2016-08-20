package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.domain.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Структура секции Data запроса к сервису BPay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqBpay extends Data{

    @XmlElement(name = "bpay")
    private BPayOptions bPayOptions;

    public BPayOptions getbPayOptions(){
        return bPayOptions;
    }

    public void setbPayOptions(BPayOptions bPayOptions){
        this.bPayOptions = bPayOptions;
    }
}
