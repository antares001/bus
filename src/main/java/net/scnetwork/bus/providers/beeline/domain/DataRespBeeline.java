package net.scnetwork.bus.providers.beeline.domain;

import net.scnetwork.bus.domain.DataResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Формирование секции XML Data для сервиса Beeline
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespBeeline extends DataResponse {
    @XmlAttribute(name = "beeline_reponse")
    private String beelineResponse;

    /**
     * Ответ от Beeline
     * @return ответ
     */
    public String getBeelineResponse() {
        return beelineResponse;
    }

    /**
     * Запись ответа Beeline
     * @param beelineResponse ответ
     */
    public void setBeelineResponse(String beelineResponse) {
        this.beelineResponse = beelineResponse;
    }
}
