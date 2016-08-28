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

    /**
     * Тип хранилища логов
     * @return тип
     */
    public String getType() {
        return type;
    }

    /**
     * Запись типа хранилища логов
     * @param type тип
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Уровень логирования
     * @return уровень
     */
    public int getLevel() {
        return level;
    }

    /**
     * Запись уровня логирования
     * @param level уровень
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
