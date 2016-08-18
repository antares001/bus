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

    @Override
    public boolean isSoap() {
        return soap;
    }

    @Override
    public void setSoap(boolean soap) {
        this.soap = soap;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
