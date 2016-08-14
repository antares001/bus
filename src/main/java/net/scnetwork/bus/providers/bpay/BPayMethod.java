package net.scnetwork.bus.providers.bpay;

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
