package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.StatusEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Формирование секции Data в ответе
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespError extends DataResponse {
    /**
     * Инициализация стандартных параметров
     * @param status статус
     */
    public DataRespError(StatusEnum status){
        setStatus(status);
        setDescription(status.getName());
    }
}
