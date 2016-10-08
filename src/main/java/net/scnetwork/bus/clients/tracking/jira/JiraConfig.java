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
    private String url;
    private String username;
    private String password;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
