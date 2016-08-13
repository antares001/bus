package net.scnetwork.bus.ui.controller;

import com.ejt.vaadin.loginform.DefaultVerticalLoginForm;
import com.ejt.vaadin.loginform.LoginForm;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI(path = "/admin/login")
@Title("Авторизация")
@Theme("valo")
public class LoginController extends UI{
    public static final String PAGE = "login";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        DefaultVerticalLoginForm loginForm = new DefaultVerticalLoginForm();
        loginForm.addLoginListener((LoginForm.LoginListener) loginEvent -> Notification.show("hello"));
        setContent(loginForm);
    }
}
