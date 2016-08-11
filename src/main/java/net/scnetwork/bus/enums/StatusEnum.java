package net.scnetwork.bus.enums;

public enum StatusEnum {
    OK("ok"),
    FORMAT_ERROR("format_error"),
    NOT_AUTH("not_auth"),
    NULL("request_is_null"),
    NOT_SUPPORT("service_is_not_support"),
    ERROR_CONFIG("config_error"),
    ERROR("error");

    private String name;

    StatusEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
