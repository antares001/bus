package net.scnetwork.bus.domain;

/**
 * Ответ JSON
 */
public class ResponseJs {
    private int type;
    private DataJs data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public DataJs getData() {
        return data;
    }

    public void setData(DataJs data) {
        this.data = data;
    }
}
