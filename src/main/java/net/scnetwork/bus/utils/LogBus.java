package net.scnetwork.bus.utils;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.config.LogConfig;
import net.scnetwork.bus.enums.LogEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Система логирования
 */
public class LogBus {
    private static LogConfig logConfig;
    private static final Logger logger = LoggerFactory.getLogger("BUS");


    private LogBus(){
        try{
            Global instance = Config.getInstance();
            if (null != instance) {
                logConfig = instance.getLogConfig();
            }
        } catch (Exception e){
            writeLog(e);
        }
    }

    /**
     * Запись инцедентов
     * @param message сообщение
     */
    public static void writeLog(Exception message){
        switch (LogEnums.valueOf(logConfig.getType())){
            case LOCAL:
                logger.info(message.toString());
                break;
            case POSTGRESQL:
            case MYSQL:
            case ORACLE:
            case SQLITE:
            case SYSLOG:
            case LOGSTASH:
            default:
                break;
        }
    }

    /**
     * Запись инцедентов с указанием системы
     * @param message сообщение
     * @param system система
     */
    public static void writeSystemLog(Exception message, String system){
        Logger logger = LoggerFactory.getLogger(system);
        switch (LogEnums.valueOf(logConfig.getType())){
            case LOCAL:
                logger.info(message.toString());
                break;
            case POSTGRESQL:
            case MYSQL:
            case ORACLE:
            case SQLITE:
            case SYSLOG:
            case LOGSTASH:
            default:
                break;
        }
    }

    /**
     * Запись событий
     * @param request событие
     */
    public static void info(String request) {
        logger.info(request);
    }
}
