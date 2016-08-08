package net.scnetwork.bus.config;

public class Config {
    private static Global global;

    public static Global getInstance(){
        if (null == global){
            throw new Error();
        }
        return global;
    }

    public static void setInstance(Global arg){
        global = arg;
    }
}
