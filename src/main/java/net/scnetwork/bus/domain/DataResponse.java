package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;

/**
 * Формирование Data ответа
 */
public abstract class DataResponse extends Data {
    /**
     * Получение ответа
     * @return ответ
     */
    public abstract String getResponse();

    /**
     * Запись ответа
     * @param response ответ
     */
    public abstract void setResponse(String response);

    /**
     * Получение статусв
     * @return статус
     */
    public abstract StatusEnum getStatus();

    /**
     * Запись статуса
     * @param status статус
     */
    public abstract void setStatus(StatusEnum status);

    /**
     * Получение сервиса
     * @return сервис
     */
    public abstract ServiceEnum getService();

    /**
     * Запись сервиса
     * @param service сервис
     */
    public abstract void setService(ServiceEnum service);

    /**
     * Получение описания
     * @return описание
     */
    public abstract String getDescription();

    /**
     * Запись описания
     * @param description описание
     */
    public abstract void setDescription(String description);
}
