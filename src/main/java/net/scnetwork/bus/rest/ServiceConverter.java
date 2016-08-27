package net.scnetwork.bus.rest;

import net.scnetwork.bus.enums.ServiceEnum;

import java.beans.PropertyEditorSupport;

/**
 * Конвертация enum <=> String
 */
public class ServiceConverter extends PropertyEditorSupport {
    /**
     * String => enum
     * @param text строка
     */
    @Override
    public void setAsText(String text){
        ServiceEnum service = ServiceEnum.valueOf(text.toUpperCase());
        setValue(service);
    }
}
