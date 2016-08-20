package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;

/**
 * Формирование Data ответа
 */
public abstract class DataResponse extends Data {
    public abstract String getResponse();

    public abstract void setResponse(String response);

    public abstract StatusEnum getStatus();

    public abstract void setStatus(StatusEnum status);

    public abstract ServiceEnum getService();

    public abstract void setService(ServiceEnum service);

    public abstract String getDescription();

    public abstract void setDescription(String description);
}
