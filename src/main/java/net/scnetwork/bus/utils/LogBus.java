package net.scnetwork.bus.utils;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.LogConfig;
import net.scnetwork.bus.enums.LogEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBus {
    private static LogConfig logConfig = Config.getInstance().getLogConfig();

    private static final Logger logger = LoggerFactory.getLogger("BUS");

    public void info(){}

    public void debug(){}

    public void error(){}

    public static void writeLog(Exception message){
        switch (LogEnums.valueOf(logConfig.getType())){
            case LOCAL:
                logger.info(message.toString());
                break;
            case POSTGRESQL:
                break;
            case MYSQL:
                break;
            case ORACLE:
                break;
            case SQLITE:
                break;
            case SYSLOG:
                break;
            default:
                break;
        }
    }
}
