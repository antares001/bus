package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.*;

/**
 * Авторизационный модуль запроса (Request) XML
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Auth")
public class Auth {
    @XmlAttribute(name = "login")
    private String login;

    @XmlAttribute(name = "pass")
    private String pass;

    @XmlAttribute(name = "service")
    private ServiceEnum service;

    /**
     * Получение логина
     * @return логин
     */
    public String getLogin() {
        return login;
    }

    /**
     * Запись логина
     * @param login логин
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Получение пароля
     * @return пароль
     */
    public String getPass() {
        return pass;
    }

    /**
     * Запись пароля
     * @param pass пароль
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Получение типа сервиса
     * @return тип сервиса
     */
    public ServiceEnum getService() {
        return service;
    }

    /**
     * Запись типа сервиса
     * @param service тип сервиса
     */
    public void setService(ServiceEnum service) {
        this.service = service;
    }
}
