package net.scnetwork.bus.utils;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.LogConfig;
import net.scnetwork.bus.enums.LogEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBus {
    private static LogConfig logConfig = Config.getInstance().getLogConfig();

    private static final Logger logger = LoggerFactory.getLogger("BUS");

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
