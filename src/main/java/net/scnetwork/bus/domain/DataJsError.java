package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.StatusEnum;

/**
 * Data JSON для ошибок
 */
public class DataJsError extends DataJs{
    private StatusEnum status;

    /**
     * Статус
     * @return статус
     */
    public StatusEnum getStatus() {
        return status;
    }

    /**
     * Запись статуса
     * @param status статус
     */
    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
