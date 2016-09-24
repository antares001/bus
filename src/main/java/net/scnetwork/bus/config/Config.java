package net.scnetwork.bus.config;

import javax.validation.constraints.NotNull;

/**
 * Singleton для хранения конфигурации
 */
public class Config {
    private static Global global;

    private Config(){}

    /**
     * Получение эксземляра конфигурации
     * @return конфигурация
     */
    public static Global getInstance(){
        if (null == global){
            synchronized (Global.class){
                if (null == global)
                    return null;
            }
        }
        return global;
    }

    /**
     * Запись конфигурации
     * @param arg конфигурация
     */
    public static void setInstance(Global arg){
        global = arg;
    }

    /**
     * Получение списка модулей
     * @return список модулей
     */
    public static Modules getModules(){
        if (null == global){
            return null;
        } else {
            return global.getModules();
        }
    }

    /**
     * Запись модулей
     * @param modules модули
     */
    public static void setModules(@NotNull  Modules modules){
        global.setModules(modules);
    }
}
