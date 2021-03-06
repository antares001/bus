package net.scnetwork.bus.clients.mina;

import net.scnetwork.bus.config.IModules;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация для сервиса Visa
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "visa")
public class VisaConfig implements IModules{
    private boolean use;

    @Override
    public boolean isUse() {
        return use;
    }

    @Override
    public void setUse(boolean use) {
        this.use = use;
    }
}
