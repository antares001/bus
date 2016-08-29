package net.scnetwork.bus.domain;

/**
 * JSON Data запроса
 */
public class DataJsRequest extends DataJs{
    private int id;

    /**
     * Идентификатор запроса
     * @return идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Запись идентификатора запроса
     * @param id идентификатор
     */
    public void setId(int id) {
        this.id = id;
    }
}
