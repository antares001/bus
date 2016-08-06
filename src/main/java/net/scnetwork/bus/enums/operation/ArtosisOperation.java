package net.scnetwork.bus.enums.operation;

public enum ArtosisOperation {
    BILL("bill"),
    CALLBACK("callback"),
    PAY("pay"),
    INFO("info");

    private String name;

    ArtosisOperation(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
