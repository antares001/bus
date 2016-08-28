package net.scnetwork.bus.clients.tracking.otrs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация OTRS
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "otrs")
public class OtrsConfig {
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
