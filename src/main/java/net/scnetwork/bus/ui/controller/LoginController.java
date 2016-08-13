package net.scnetwork.bus.ui.controller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI(path = "/admin/login")
@Title("Авторизация")
@Theme("valo")
public class LoginController extends UI{
    public static final String PAGE = "login";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Button("Click", e -> Notification.show("hello")));
    }
}
