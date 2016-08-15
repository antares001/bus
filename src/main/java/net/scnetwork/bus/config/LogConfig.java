package net.scnetwork.bus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация логирования
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "log")
public class LogConfig {
    private String type;
    private int level;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
