package net.scnetwork.bus.domain;

/**
 * Ответ JSON
 */
public class ResponseJs {
    private int type;
    private DataJs data;

    /**
     * Получение типа ответа
     * @return тип
     */
    public int getType() {
        return type;
    }

    /**
     * Запись типа ответа
     * @param type тип
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Получение секции Data
     * @return секция Data
     */
    public DataJs getData() {
        return data;
    }

    /**
     * Запись секции Data
     * @param data секция Data
     */
    public void setData(DataJs data) {
        this.data = data;
    }
}
