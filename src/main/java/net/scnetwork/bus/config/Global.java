package net.scnetwork.bus.config;

import net.scnetwork.bus.dao.mysql.MysqlConfig;
import net.scnetwork.bus.dao.mysqlpool.MysqlPoolConfig;
import net.scnetwork.bus.dao.oracle.OracleConfig;
import net.scnetwork.bus.dao.orapool.OraclePoolConfig;
import net.scnetwork.bus.dao.postgrepool.PgPoolConfig;
import net.scnetwork.bus.dao.postgresql.PostgreConfig;
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

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Modules getModules() {
        return modules;
    }

    public void setModules(Modules modules) {
        this.modules = modules;
    }

    public DaoEnums getDao() {
        return dao;
    }

    public void setDao(DaoEnums dao) {
        this.dao = dao;
    }

    public PgPoolConfig getPgPoolConfig() {
        return pgPoolConfig;
    }

    public void setPgPoolConfig(PgPoolConfig pgPoolConfig) {
        this.pgPoolConfig = pgPoolConfig;
    }

    public PostgreConfig getPostgreConfig() {
        return postgreConfig;
    }

    public void setPostgreConfig(PostgreConfig postgreConfig) {
        this.postgreConfig = postgreConfig;
    }

    public OracleConfig getOracleConfig() {
        return oracleConfig;
    }

    public void setOracleConfig(OracleConfig oracleConfig) {
        this.oracleConfig = oracleConfig;
    }

    public OraclePoolConfig getOraclePoolConfig() {
        return oraclePoolConfig;
    }

    public void setOraclePoolConfig(OraclePoolConfig oraclePoolConfig) {
        this.oraclePoolConfig = oraclePoolConfig;
    }

    public MysqlConfig getMysqlConfig() {
        return mysqlConfig;
    }

    public void setMysqlConfig(MysqlConfig mysqlConfig) {
        this.mysqlConfig = mysqlConfig;
    }

    public MysqlPoolConfig getMysqlPoolConfig() {
        return mysqlPoolConfig;
    }

    public void setMysqlPoolConfig(MysqlPoolConfig mysqlPoolConfig) {
        this.mysqlPoolConfig = mysqlPoolConfig;
    }

    public LogConfig getLogConfig() {
        return logConfig;
    }

    public void setLogConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
    }

    public boolean isGui() {
        return gui;
    }

    public void setGui(boolean gui) {
        this.gui = gui;
    }

    /**
     * Приведение объекта к строке
     * @return строка
     */
    @Override
    public String toString(){
        return endpoint + " <=> " +
                modules.toString() + "<=>" +
                dao.toString();
    }
}
