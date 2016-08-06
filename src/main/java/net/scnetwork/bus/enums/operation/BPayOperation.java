package net.scnetwork.bus.enums.operation;

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
