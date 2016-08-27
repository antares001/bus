package net.scnetwork.bus.domain;


import net.scnetwork.bus.enums.OperationEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data запроса
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public abstract class DataRequest extends Data{
    @XmlAttribute(name = "account")
    private String account;

    @XmlAttribute(name = "operation")
    private OperationEnum operation;

    /**
     * Получение аккаунта
     * @return аккаунт
     */
    public String getAccount(){
        return account;
    }

    /**
     * Запись аккаунта
     * @param account аккаунт
     */
    public void setAccount(String account){
        this.account = account;
    }

    /**
     * Получение типа операции
     * @return тип операции
     */
    public OperationEnum getOperation(){
        return operation;
    }

    /**
     * Запись типа операции
     * @param operation тип операции
     */
    public void setOperation(OperationEnum operation){
        this.operation = operation;
    }
}
