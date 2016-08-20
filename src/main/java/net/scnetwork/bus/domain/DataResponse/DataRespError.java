package net.scnetwork.bus.domain.DataResponse;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.enums.StatusEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Формирование секции Data в ответе
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespError extends Data {

    /**
     * Инициализация стандартных параметров
     * @param statusEnum статус
     */
    public DataRespError(StatusEnum statusEnum){
        setStatus(statusEnum);
        setDescription(statusEnum.getName());
    }
}
