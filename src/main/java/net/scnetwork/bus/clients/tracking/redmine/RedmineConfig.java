package net.scnetwork.bus.clients.tracking.redmine;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация Redmine
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "redmine")
public class RedmineConfig {
    private boolean use;

    /**
     * Признак использования
     * @return использование
     */
    public boolean isUse() {
        return use;
    }

    /**
     * Запись признака использования
     * @param use использование
     */
    public void setUse(boolean use) {
        this.use = use;
    }
}
