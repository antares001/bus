package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;

/**
 * Формирование Data ответа
 */
public interface DataResponse extends Data {
    String getResponse();

    void setResponse(String response);

    StatusEnum getStatus();

    void setStatus(StatusEnum status);

    ServiceEnum getService();

    void setService(ServiceEnum service);

    String getDescription();

    void setDescription(String description);
}
