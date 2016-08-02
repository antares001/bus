package net.scnetwork.bus.domain;

import net.scnetwork.bus.enums.ServiceEnum;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Auth")
public class Auth {
    @XmlAttribute(name = "login")
    private String login;

    @XmlAttribute(name = "pass")
    private String pass;

    @XmlAttribute(name = "service")
    private ServiceEnum service;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ServiceEnum getService() {
        return service;
    }

    public void setService(ServiceEnum service) {
        this.service = service;
    }
}
