package net.scnetwork.bus.providers.bpay.enums;

/**
 * Перечень языков для BPay
 */
public enum BPayLang {
    EN("en"),
    RU("ru"),
    RO("ro");

    private String name;

    BPayLang(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
