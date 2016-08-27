package net.scnetwork.bus.providers.fias.domain;

import net.scnetwork.bus.domain.DataResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Data XML ответа сервиса bpay
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespFias extends DataResponse{

    @XmlElement(name = "params")
    private List<ParamFias> paramList;

    /**
     * Список параметров
     * @return список
     */
    public List<ParamFias> getParamList() {
        return paramList;
    }

    /**
     * Запись списка параметров
     * @param paramList список
     */
    public void setParamList(List<ParamFias> paramList) {
        this.paramList = paramList;
    }
}
