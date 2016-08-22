package net.scnetwork.bus.providers.forex.domain;

import net.scnetwork.bus.domain.DataResponse;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Формирование XML ответа для сервиса Forex
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class DataRespForex extends DataResponse{
    @XmlElement(name = "date")
    private Date date;

    @XmlElement(name = "response")
    private String response;

    @XmlElement(name = "status")
    private StatusEnum status;

    @XmlElement(name = "service")
    private ServiceEnum service;

    @XmlElement(name = "description")
    private String description;

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public StatusEnum getStatus() {
        return status;
    }

    @Override
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public ServiceEnum getService() {
        return service;
    }

    @Override
    public void setService(ServiceEnum service) {
        this.service = service;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
