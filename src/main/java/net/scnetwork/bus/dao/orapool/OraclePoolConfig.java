package net.scnetwork.bus.dao.orapool;

import net.scnetwork.bus.dao.IConfigDaoPool;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для пула подключений Oracle
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "oracle-pool")
public class OraclePoolConfig implements IConfigDaoPool{
    private String jdbcUrl;
    private String username;
    private String password;
    private int maxLimit;
    private int initialLimit;
    private int connectionTimeout;

    @Override
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    @Override
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getMaxLimit() {
        return maxLimit;
    }

    @Override
    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public int getInitialLimit() {
        return initialLimit;
    }

    @Override
    public void setInitialLimit(int initialLimit) {
        this.initialLimit = initialLimit;
    }

    @Override
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    @Override
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
}
