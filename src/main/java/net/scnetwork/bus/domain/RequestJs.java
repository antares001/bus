package net.scnetwork.bus.domain;

public class RequestJs {
    private int type;
    private AuthJs auth;
    private DataJs data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public AuthJs getAuth() {
        return auth;
    }

    public void setAuth(AuthJs auth) {
        this.auth = auth;
    }

    public DataJs getData() {
        return data;
    }

    public void setData(DataJs data) {
        this.data = data;
    }
}
