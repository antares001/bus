package net.scnetwork.bus.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Секция Data XML
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Data")
public class Data {
    @XmlAttribute(name = "date")
    private Date date;

    /**
     * Получение даты
     * @return дата
     */
    public Date getDate(){
        return date;
    }

    /**
     * Запись даты
     * @param date дата
     */
    public void setDate(Date date){
        this.date = date;
    }
}
