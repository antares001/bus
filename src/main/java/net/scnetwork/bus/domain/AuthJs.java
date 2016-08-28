package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;

/**
 * Авторизационный модуль запроса (Request) JSON
 */
public class AuthJs {
    private String login;
    private String password;
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
    public String getPassword() {
        return password;
    }

    /**
     * Запись пароля
     * @param password пароль
     */
    public void setPassword(String password) {
        this.password = password;
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
