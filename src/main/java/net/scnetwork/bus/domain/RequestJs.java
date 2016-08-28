package net.scnetwork.bus.domain;

/**
 * Запрос JSON
 */
public class RequestJs {
    private int type;
    private AuthJs auth;
    private DataJs data;

    /**
     * Получение типа запроса
     * @return тип
     */
    public int getType() {
        return type;
    }

    /**
     * Запись типа запроса
     * @param type тип
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Плоучение модуля авторизации
     * @return модуль авторизации
     */
    public AuthJs getAuth() {
        return auth;
    }

    /**
     * Запись модуля авторизации
     * @param auth модуль авторизации
     */
    public void setAuth(AuthJs auth) {
        this.auth = auth;
    }

    /**
     * Получение модуля Data
     * @return модуль Data
     */
    public DataJs getData() {
        return data;
    }

    /**
     * Запись модуля Data
     * @param data модуль Data
     */
    public void setData(DataJs data) {
        this.data = data;
    }
}
