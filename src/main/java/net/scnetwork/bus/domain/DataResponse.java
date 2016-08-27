package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Формирование Data ответа
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public abstract class DataResponse extends Data {
    @XmlAttribute(name = "response")
    private String response;

    @XmlAttribute(name = "status")
    private StatusEnum status;

    @XmlAttribute(name = "service")
    private ServiceEnum service;

    @XmlAttribute(name = "description")
    private String description;

    /**
     * Получение ответа
     * @return ответ
     */
    public String getResponse(){
        return response;
    }

    /**
     * Запись ответа
     * @param response ответ
     */
    public void setResponse(String response){
        this.response = response;
    }

    /**
     * Получение статусв
     * @return статус
     */
    public StatusEnum getStatus(){
        return status;
    }

    /**
     * Запись статуса
     * @param status статус
     */
    public void setStatus(StatusEnum status){
        this.status = status;
    }

    /**
     * Получение сервиса
     * @return сервис
     */
    public ServiceEnum getService(){
        return service;
    }

    /**
     * Запись сервиса
     * @param service сервис
     */
    public void setService(ServiceEnum service){
        this.service = service;
    }

    /**
     * Получение описания
     * @return описание
     */
    public String getDescription(){
        return description;
    }

    /**
     * Запись описания
     * @param description описание
     */
    public void setDescription(String description){
        this.description = description;
    }
}
