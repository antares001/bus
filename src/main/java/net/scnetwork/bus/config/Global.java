package net.scnetwork.bus.config;

import net.scnetwork.bus.dao.MysqlConfig;
import net.scnetwork.bus.dao.OracleConfig;
import net.scnetwork.bus.dao.PostgreConfig;
import net.scnetwork.bus.dao.mysqlpool.MysqlPoolConfig;
import net.scnetwork.bus.dao.orapool.OraclePoolConfig;
import net.scnetwork.bus.dao.postgrepool.PgPoolConfig;
import net.scnetwork.bus.enums.DaoEnums;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Глобальная конфигурация
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Global {
    private String endpoint;
    private Modules modules;
    private DaoEnums dao;
    private OraclePoolConfig oraclePoolConfig;
    private OracleConfig oracleConfig;
    private PgPoolConfig pgPoolConfig;
    private PostgreConfig postgreConfig;
    private MysqlConfig mysqlConfig;
    private MysqlPoolConfig mysqlPoolConfig;
    private LogConfig logConfig;
    private boolean gui;

    /**
     * Получение адреса единой точки
     * @return адрес единой точки
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Запись адреса единой точки
     * @param endpoint адрес единой точки
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Получение настроек модулей
     * @return настройки модулей
     */
    public Modules getModules() {
        return modules;
    }

    /**
     * Запись настроек модулей
     * @param modules настройки модулей
     */
    public void setModules(Modules modules) {
        this.modules = modules;
    }

    /**
     * Получение типа подключения к БД
     * @return тип подключения к БД
     */
    public DaoEnums getDao() {
        return dao;
    }

    /**
     * Запись типа подключения к БД
     * @param dao тип подключения к БД
     */
    public void setDao(DaoEnums dao) {
        this.dao = dao;
    }

    /**
     * Настройки подключения пула к postgre
     * @return настройки
     */
    public PgPoolConfig getPgPoolConfig() {
        return pgPoolConfig;
    }

    /**
     * Запись подключения пула к postgre
     * @param pgPoolConfig настройки
     */
    public void setPgPoolConfig(PgPoolConfig pgPoolConfig) {
        this.pgPoolConfig = pgPoolConfig;
    }

    /**
     * Получение настроек подключения к postgre
     * @return настройки
     */
    public PostgreConfig getPostgreConfig() {
        return postgreConfig;
    }

    /**
     * Запись подключения к postgre
     * @param postgreConfig настройки
     */
    public void setPostgreConfig(PostgreConfig postgreConfig) {
        this.postgreConfig = postgreConfig;
    }

    /**
     * Получения настроек подключения к oracle
     * @return настройки
     */
    public OracleConfig getOracleConfig() {
        return oracleConfig;
    }

    /**
     * Запись настроек подключения к oracle
     * @param oracleConfig настройки
     */
    public void setOracleConfig(OracleConfig oracleConfig) {
        this.oracleConfig = oracleConfig;
    }

    /**
     * Получение настроек подключения пула к oracle
     * @return настройки
     */
    public OraclePoolConfig getOraclePoolConfig() {
        return oraclePoolConfig;
    }

    /**
     * Запись подключения пула к oracle
     * @param oraclePoolConfig настройки
     */
    public void setOraclePoolConfig(OraclePoolConfig oraclePoolConfig) {
        this.oraclePoolConfig = oraclePoolConfig;
    }

    /**
     * Получение настроек подключения к mysql
     * @return настройки
     */
    public MysqlConfig getMysqlConfig() {
        return mysqlConfig;
    }

    /**
     * Запись настроек подклчения к mysql
     * @param mysqlConfig настройки
     */
    public void setMysqlConfig(MysqlConfig mysqlConfig) {
        this.mysqlConfig = mysqlConfig;
    }

    /**
     * Полуучение настроек подключения пула к mysql
     * @return настройки
     */
    public MysqlPoolConfig getMysqlPoolConfig() {
        return mysqlPoolConfig;
    }

    /**
     * Запись настроек подключения пула к mysql
     * @param mysqlPoolConfig настройки
     */
    public void setMysqlPoolConfig(MysqlPoolConfig mysqlPoolConfig) {
        this.mysqlPoolConfig = mysqlPoolConfig;
    }

    /**
     * Получение настроек логирования
     * @return настройки
     */
    public LogConfig getLogConfig() {
        return logConfig;
    }

    /**
     * Запись настроек логирования
     * @param logConfig настройки
     */
    public void setLogConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
    }

    /**
     * Получение использования WebUI
     * @return использование
     */
    public boolean isGui() {
        return gui;
    }

    /**
     * Запись использования WebUI
     * @param gui использование
     */
    public void setGui(boolean gui) {
        this.gui = gui;
    }

    /**
     * Приведение объекта к строке
     * @return строка
     */
    @Override
    public String toString(){
        return "Config: {" +
                "endopoint:" + endpoint +
                ",modules:{" + modules.toString() +
                "},dao: " + dao.getName() + "" +
                ",PotsgrePoolConfig:{" + pgPoolConfig.toString()  +
                "},PostgreConfig:{" + postgreConfig.toString() +
                "},OraclePoolConfig:{" + oraclePoolConfig.toString() +
                "}, OracleConfig:{" + oracleConfig.toString() +
                "},MysqlPoolConfig:{" + mysqlPoolConfig.toString() +
                "},MysqlConfig:{" + mysqlConfig.toString() +
                "},LogConfig:{" + logConfig.toString() +
                "},GUI:" + gui + "}";
    }
}
