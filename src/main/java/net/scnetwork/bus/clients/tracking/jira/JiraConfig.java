package net.scnetwork.bus.clients.tracking.jira;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Кинфигурация jira
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "jira")
public class JiraConfig {
    private boolean use;

    /**
     * Признак использования
     * @return использование
     */
    public boolean isUse() {
        return use;
    }

    /**
     * Запись использования
     * @param use использование
     */
    public void setUse(boolean use) {
        this.use = use;
    }
}
