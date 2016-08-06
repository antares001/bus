package net.scnetwork.bus.config;

import net.scnetwork.bus.config.modules.Modules;
import net.scnetwork.bus.enums.DaoEnums;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class Global {
    private Modules modules;
    private DaoEnums dao;
    private OraclePoolConfig oraclePoolConfig;

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

    public OraclePoolConfig getOraclePoolConfig() {
        return oraclePoolConfig;
    }

    public void setOraclePoolConfig(OraclePoolConfig oraclePoolConfig) {
        this.oraclePoolConfig = oraclePoolConfig;
    }
}
