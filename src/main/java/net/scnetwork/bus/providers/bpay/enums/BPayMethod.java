package net.scnetwork.bus.providers.bpay.enums;

/**
 * Перечень методов для BPay
 */
public enum BPayMethod {
    BPAY("bpay"),
    CARD("card"),
    WEBMONEY("webmoney"),
    YAMONEY("yamoney");

    private String name;

    BPayMethod(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
