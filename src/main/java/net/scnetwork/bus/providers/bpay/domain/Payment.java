package net.scnetwork.bus.providers.bpay.domain;

import net.scnetwork.bus.providers.bpay.enums.BPayLang;
import net.scnetwork.bus.providers.bpay.enums.BPayMethod;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Формирование XML к системе BPay
 */
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

    /**
     * Получение типа
     * @return тип
     */
    public String getType() {
        return type;
    }

    /**
     * Запись типа
     * @param type тип
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Получение merchantId
      * @return merchantId
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Запись merchantId
     * @param merchantId параметр
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Получение суммы
     * @return сумма
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Запись суммы
     * @param amount сумма
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Получение описания
     * @return описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Запись описания
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Получение метода
     * @return метод
     */
    public BPayMethod getMethod() {
        return method;
    }

    /**
     * Запись метода
     * @param method метод
     */
    public void setMethod(BPayMethod method) {
        this.method = method;
    }

    /**
     * Получение orderId
     * @return orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Запись orderID
     * @param orderId параметр
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Получение адреса
     * @return адрес
     */
    public String getSuccessUrl() {
        return successUrl;
    }

    /**
     * Запись адреса
     * @param successUrl адрес
     */
    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    /**
     * Получение адреса ошибки
     * @return адрес ошибки
     */
    public String getFailUrl() {
        return failUrl;
    }

    /**
     * Запись адреса ошибки
     * @param failUrl адрес ошибки
     */
    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    /**
     * Получение адреса
     * @return адрес
     */
    public String getCallbackUrl() {
        return callbackUrl;
    }

    /**
     * Запись адреса
     * @param callbackUrl
     */
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * Получения языка
     * @return язык
     */
    public BPayLang getLang() {
        return lang;
    }

    /**
     * Запись языка
     * @param lang язык
     */
    public void setLang(BPayLang lang) {
        this.lang = lang;
    }

    /**
     * Получение дополнительной информации
     * @return дополнительная информация
     */
    public String getAdvanced1() {
        return advanced1;
    }

    /**
     * Запись дополнительной информации
     * @param advanced1 дополнительная информация
     */
    public void setAdvanced1(String advanced1) {
        this.advanced1 = advanced1;
    }

    /**
     * Получение дополнительной информации 2
     * @return дополнительная информация 2
     */
    public String getAdvanced2() {
        return advanced2;
    }

    /**
     * Запись дополнительной информации 2
     * @param advanced2 дополнительная информация 2
     */
    public void setAdvanced2(String advanced2) {
        this.advanced2 = advanced2;
    }

    /**
     * Получение url
     * @return url
     */
    public int getGetUrl() {
        return getUrl;
    }

    /**
     * Запись url
     * @param getUrl url
     */
    public void setGetUrl(int getUrl) {
        this.getUrl = getUrl;
    }

    /**
     * Получение признака тестирования
     * @return признак тестирования
     */
    public int getIstest() {
        return istest;
    }

    /**
     * Запись признака тестирования
     * @param istest признак тестирования
     */
    public void setIstest(int istest) {
        this.istest = istest;
    }

    /**
     * Получение валюты
     * @return валюта
     */
    public int getValute() {
        return valute;
    }

    /**
     * Запись валюты
     * @param valute валюта
     */
    public void setValute(int valute) {
        this.valute = valute;
    }
}
