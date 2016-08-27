package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.domain.DataRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Структура секции Data запроса к сервису BPay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataReqBpay extends DataRequest{
    @XmlElement(name = "bpay")
    private BPayOptions bPayOptions;

    /**
     * Получение параметров запроса bpay
     * @return параметры
     */
    public BPayOptions getbPayOptions(){
        return bPayOptions;
    }

    /**
     * Запись параметров
     * @param bPayOptions параметры
     */
    public void setbPayOptions(BPayOptions bPayOptions){
        this.bPayOptions = bPayOptions;
    }
}
