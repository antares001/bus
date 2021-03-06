package net.scnetwork.bus.providers.bpay.enums;

/**
 * Операции с сервисом BPay
 */
public enum BPayOperation {
    BILL("bill"),
    CALLBACK("callback"),
    PAY("pay"),
    INFO("info");

    private String name;

    BPayOperation(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
