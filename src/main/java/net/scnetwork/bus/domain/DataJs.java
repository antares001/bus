package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.StatusEnum;

import java.util.Date;

public class DataJs {
    private StatusEnum status;
    private String operation;
    private Date date;
    private String account;

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
