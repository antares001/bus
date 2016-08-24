package net.scnetwork.bus.dao.mysqlPool;


import net.scnetwork.bus.dao.IConfigDao;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Настройка пула подключений к MySql
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mysql-pool")
public class MysqlPoolConfig implements IConfigDao{
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
