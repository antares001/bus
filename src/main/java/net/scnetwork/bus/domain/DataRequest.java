package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.OperationEnum;

public interface DataRequest extends Data{
    /**
     * Получение аккаунта
     * @return аккаунт
     */
    String getAccount();

    /**
     * Запись аккаунта
     * @param account аккаунт
     */
    void setAccount(String account);

    /**
     * Получение типа операции
     * @return тип операции
     */
    OperationEnum getOperation();

    /**
     * Запись типа операции
     * @param operation тип операции
     */
    void setOperation(OperationEnum operation);
}
