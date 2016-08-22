package net.scnetwork.bus.providers.yandex.enums;

/**
 * Операции стороннего сервиса Yandex
 */
public enum YandexOperation {
    ACCOUNT_INFO("account_info"),
    OPERATION_HISTORY("operation_history"),
    OPERATION_DETAILS("operation_details"),
    INCOMING_TRANSFERS("incoming_transfers"),
    PAYMENT("payment"),
    PAYMENT_SHOP("payment_shop"),
    PAYMENT_P2P("payment_p2p"),
    MONEY_SOURCE("money_source");

    private String name;

    YandexOperation(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
