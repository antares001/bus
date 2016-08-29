package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.StatusEnum;

/**
 * JSON Data ответа
 */
public class DataJsResponse extends DataJs{
    private StatusEnum status;
    private String result;

    /**
     * Получение статуса
     * @return статус
     */
    public StatusEnum getStatus() {
        return status;
    }

    /**
     * Заспись статуса
     * @param status статус
     */
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    /**
     * Рузальтат запроса
     * @return результат
     */
    public String getResult() {
        return result;
    }

    /**
     * Запись результата
     * @param result результат
     */
    public void setResult(String result) {
        this.result = result;
    }
}
