package net.scnetwork.bus.domain;

import java.util.Date;

/**
 * Секция Data XML
 */
public interface Data {
    /**
     * Получение даты
     * @return дата
     */
    Date getDate();

    /**
     * Запись даты
     * @param date дата
     */
    void setDate(Date date);
}
