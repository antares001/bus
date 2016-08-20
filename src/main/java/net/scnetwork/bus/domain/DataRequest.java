package net.scnetwork.bus.domain;


import net.scnetwork.bus.enums.OperationEnum;

public abstract class DataRequest extends Data{
    /**
     * Получение аккаунта
     * @return аккаунт
     */
    public abstract String getAccount();

    /**
     * Запись аккаунта
     * @param account аккаунт
     */
    public abstract void setAccount(String account);

    /**
     * Получение типа операции
     * @return тип операции
     */
    public abstract OperationEnum getOperation();

    /**
     * Запись типа операции
     * @param operation тип операции
     */
    public  abstract void setOperation(OperationEnum operation);
}
