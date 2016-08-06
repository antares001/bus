package net.scnetwork.bus.providers.Bpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "payment")
public class Payment {
    @XmlElement(name = "type")
    private String type;

    @XmlElement(name = "merchantid")
    private String merchantId;

    @XmlElement(name = "amount")
    private BigDecimal amount;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "method")
    private BPayMethod method;

    @XmlElement(name = "order_id")
    private String orderId;

    @XmlElement(name = "success_url")
    private String successUrl;

    @XmlElement(name = "fail_url")
    private String failUrl;

    @XmlElement(name = "callback_url")
    private String callbackUrl;

    @XmlElement(name = "lang")
    private BPayLang lang;

    @XmlElement(name = "advanced1")
    private String advanced1;

    @XmlElement(name = "advanced2")
    private String advanced2;

    @XmlElement(name = "istest")
    private int istest;

    @XmlElement(name = "getUrl")
    private int getUrl;

    @XmlElement(name = "valute")
    private int valute;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BPayMethod getMethod() {
        return method;
    }

    public void setMethod(BPayMethod method) {
        this.method = method;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public BPayLang getLang() {
        return lang;
    }

    public void setLang(BPayLang lang) {
        this.lang = lang;
    }

    public String getAdvanced1() {
        return advanced1;
    }

    public void setAdvanced1(String advanced1) {
        this.advanced1 = advanced1;
    }

    public String getAdvanced2() {
        return advanced2;
    }

    public void setAdvanced2(String advanced2) {
        this.advanced2 = advanced2;
    }

    public int getGetUrl() {
        return getUrl;
    }

    public void setGetUrl(int getUrl) {
        this.getUrl = getUrl;
    }

    public int getIstest() {
        return istest;
    }

    public void setIstest(int istest) {
        this.istest = istest;
    }

    public int getValute() {
        return valute;
    }

    public void setValute(int valute) {
        this.valute = valute;
    }
}
