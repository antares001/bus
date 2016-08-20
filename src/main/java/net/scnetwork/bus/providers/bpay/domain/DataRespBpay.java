package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Формирование секции Data ответа сервиса BPay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespBpay extends Data{
    /**
     * Инициализация значений по умолчанию
     */
    public DataRespBpay(){
        setService(ServiceEnum.BPAY);
        setDate(new Date());
    }
}
