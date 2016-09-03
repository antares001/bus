package net.scnetwork.bus.providers.jpos.config;

import net.scnetwork.bus.config.IModules;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса JPOS
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "jpos")
public class Jpos implements IModules {
    private boolean use;
    private String service;
    private String url;
    private int port;
    private int bufferSize;

    public static final String DESCRIPTION = "JPOS";

    @Override
    public boolean isUse() {
        return use;
    }

    @Override
    public void setUse(boolean use) {
        this.use = use;
    }

    @Override
    public String getService() {
        return service;
    }

    @Override
    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Порт сервиса
     * @return порт
     */
    public int getPort() {
        return port;
    }

    /**
     * Запись порта сервиса
     * @param port порт
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Размер буфера
     * @return размер
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * Запись размера буферв
     * @param bufferSize размер
     */
    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public String toString(){
        return "Jpos:{use:" + use + ",service:" + service + ",url:" + url + "}";
    }
}
