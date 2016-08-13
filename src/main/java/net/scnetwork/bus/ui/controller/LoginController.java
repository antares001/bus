package net.scnetwork.bus.ui.controller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI(path = "/admin/login")
@Title("Авторизация")
@Theme("valo")
public class LoginController extends UI{
    public static final String PAGE = "login";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();

        HorizontalLayout unLayout = new HorizontalLayout();
        unLayout.addComponent(new Label("Имя пользователя"));
        unLayout.addComponent(new TextField());
        unLayout.setMargin(true);
        layout.addComponent(unLayout);


        HorizontalLayout passLayout = new HorizontalLayout();
        passLayout.addComponent(new Label("Пароль пользователя"));
        passLayout.addComponent(new PasswordField());
        passLayout.setMargin(false);
        layout.addComponent(passLayout);

        layout.setComponentAlignment(unLayout, Alignment.TOP_CENTER);
        layout.setComponentAlignment(passLayout, Alignment.TOP_CENTER);
        setContent(layout);
    }
}
