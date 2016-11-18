package net.scnetwork.bus.enums;

/**
 * Типы статусов ответов:
 * <ol>
 *     <li>OK - успешно</li>
 *     <li>FORMAT_ERROR - ошибка в формате запроса</li>
 *     <li>NULL - пустой запрос</li>
 *     <li>ERROR_CONFIG - ошибка в конфигурационном файле</li>
 *     <li>ERROR - неизвестная ошибка</li>
 *     <li>SERVICE_DISABLED - указанный сервис отключен</li>
 *     <li>SERVICE_NOT_FOUND - указанный сервис не найден</li>
 * </ol>
 */
public enum StatusEnum {
    OK("ok"),
    FORMAT_ERROR("format_error"),
    NOT_AUTH("not_auth"),
    NULL("request_is_null"),
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
