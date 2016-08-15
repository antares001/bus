package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;

/**
 * Авторизационный модуль запроса (Request) JSON
 */
public class AuthJs {
    private String login;
    private String password;
    private ServiceEnum service;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ServiceEnum getService() {
        return service;
    }

    public void setService(ServiceEnum service) {
        this.service = service;
    }
}
