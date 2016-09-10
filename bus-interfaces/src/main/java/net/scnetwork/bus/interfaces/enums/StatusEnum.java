package net.scnetwork.bus.enums;

/**
 * Типы статусов ответов
 */
public enum StatusEnum {
    OK("ok"),
    FORMAT_ERROR("format_error"),
    NOT_AUTH("not_auth"),
    NULL("request_is_null"),
    NOT_SUPPORT("service_is_not_support"),
    ERROR_CONFIG("config_error"),
    ERROR("error"),
    SERVICE_DISABLED("service_is_disabled"),
    SERVICE_NOT_FOUND("service_is_not_found");

    private String name;

    StatusEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
