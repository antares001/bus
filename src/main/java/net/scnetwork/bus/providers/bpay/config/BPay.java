package net.scnetwork.bus.providers.bpay.config;

import net.scnetwork.bus.config.IModules;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигурация сервиса BPay
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "bpay")
public class BPay implements IModules {
    private boolean use;
    private String service;
    private String url;
    private boolean soap;
    private String point;
    private String merchantId;
    private String signature;

    public static final String DESCRIPTION = "BPay";

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
     * Использование отдельного сервиса
     * @return признак
     */
    public boolean isSoap() {
        return soap;
    }

    /**
     * Запись признака отдельного сервиса
     * @param soap признак
     */
    public void setSoap(boolean soap) {
        this.soap = soap;
    }

    /**
     * Точка подключения к удаленному сервису
     * @return точка
     */
    public String getPoint() {
        return point;
    }

    /**
     * Запись подключения к удаленному сервису
     * @param point точка
     */
    public void setPoint(String point) {
        this.point = point;
    }

    /**
     * Идентификатор мерчанта
     * @return идентификатор
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Запись идентификатора мерчанта
     * @param merchantId идентификатор
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Подпись
     * @return подпись
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Запись подписи
     * @param signature подпись
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
