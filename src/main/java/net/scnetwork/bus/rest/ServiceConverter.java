package net.scnetwork.bus.rest;

import net.scnetwork.bus.enums.ServiceEnum;

import java.beans.PropertyEditorSupport;

public class ServiceConverter extends PropertyEditorSupport {
    public void setAsText(String text){
        ServiceEnum service = ServiceEnum.valueOf(text.toUpperCase());
        setValue(service);
    }
}
