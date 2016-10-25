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
    private String uri;
    private String tokenTracker;
    private String tokenVcs;
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
     * Запись признака использования
     * @param use использование
     */
    public void setUse(boolean use) {
        this.use = use;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTokenTracker() {
        return tokenTracker;
    }

    public void setTokenTracker(String tokenTracker) {
        this.tokenTracker = tokenTracker;
    }

    public String getTokenVcs() {
        return tokenVcs;
    }

    public void setTokenVcs(String tokenVcs) {
        this.tokenVcs = tokenVcs;
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
