package net.scnetwork.bus.dao.pgPool;

import net.scnetwork.bus.dao.IConfigDao;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Настройки пула подключений для PostgreSQL
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "postgresql-pool")
public class PgPoolConfig implements IConfigDao{
    private String jdbcUrl;
    private String username;
    private String password;

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
}
