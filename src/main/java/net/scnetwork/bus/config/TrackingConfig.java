package net.scnetwork.bus.config;

import net.scnetwork.bus.clients.tracking.jira.JiraConfig;
import net.scnetwork.bus.clients.tracking.redmine.RedmineConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Настройка трекинга
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "tracking")
public class TrackingConfig {
    private boolean use;
    private JiraConfig jira;
    private RedmineConfig redmine;

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

    /**
     * Получение настроек jira
      * @return настройки
     */
    public JiraConfig getJira() {
        return jira;
    }

    /**
     * Запись настроек jira
     * @param jira настройки
     */
    public void setJira(JiraConfig jira) {
        this.jira = jira;
    }

    /**
     * Получение настроек Redmine
     * @return настройки
     */
    public RedmineConfig getRedmine() {
        return redmine;
    }

    /**
     * Запись настроек Redmine
     * @param redmine настройки
     */
    public void setRedmine(RedmineConfig redmine) {
        this.redmine = redmine;
    }
}
