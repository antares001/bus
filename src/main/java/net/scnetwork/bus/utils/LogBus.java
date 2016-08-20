package net.scnetwork.bus.utils;

import net.scnetwork.bus.config.Config;
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

    /**
     * Инициализация конфигурации
     */
    private LogBus(){
        try{
            logConfig = Config.getInstance().getLogConfig();
        } catch (NullPointerException e){
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
            default:
                break;
        }
    }
}
