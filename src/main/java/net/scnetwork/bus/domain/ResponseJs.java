package net.scnetwork.bus.domain;

/**
 * Ответ JSON
 */
public class ResponseJs {
    private Integer type;
    private DataJs data;

    /**
     * Получение типа ответа
     * @return тип
     */
    public Integer getType() {
        return type;
    }

    /**
     * Запись типа ответа
     * @param type тип
     */
    public void setType(Integer type) {
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

    @Override
    public String toString(){
        return "{" +
                "type:" + type + "," +
                "data:" + data.toString() + ",";
    }
}
