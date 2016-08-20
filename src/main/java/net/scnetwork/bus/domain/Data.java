package net.scnetwork.bus.domain;

import java.util.Date;

/**
 * Секция Data XML
 */
public abstract class Data {
    /**
     * Получение даты
     * @return дата
     */
    public abstract Date getDate();

    /**
     * Запись даты
     * @param date дата
     */
    public abstract void setDate(Date date);
}
