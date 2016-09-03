package net.scnetwork.bus.domain;

import java.util.Date;

/**
 * Формирование секции Data в формате JSON
 */
public class DataJs {
    private String operation;
    private Date date;
    private String account;

    /**
     * Тип операции
      * @return тип
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Запись типа операции
     * @param operation тип
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Дата
     * @return дата
     */
    public Date getDate() {
        return date;
    }

    /**
     * Запись даты
     * @param date дата
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Аккаунт
     * @return аккаунт
     */
    public String getAccount() {
        return account;
    }

    /**
     * Запись аккаунта
     * @param account аккаунт
     */
    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString(){
        return "{operation:" + operation + "," +
                "date:" + date.toString() + "," +
                "account:" + account + "}";
    }
}
