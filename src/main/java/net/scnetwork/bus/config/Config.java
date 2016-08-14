package net.scnetwork.bus.config;

public class Config {
    private static Global global;

    private Config(){}

    public static Global getInstance(){
        if (null == global){
            return null;
        }
        return global;
    }

    public static void setInstance(Global arg){
        global = arg;
    }
}
