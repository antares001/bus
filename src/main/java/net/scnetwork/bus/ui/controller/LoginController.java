package net.scnetwork.bus.ui.controller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.ui.util.ErrorsUI;

@SpringUI(path = "/admin/login")
@Title("Авторизация")
@Theme("valo")
public class LoginController extends UI{
    public static final String PAGE = "login";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        if (null != Config.getInstance()) {
            if (Config.getInstance().isGui()) {
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
            } else {
                VerticalLayout layout = new VerticalLayout();
                layout.addComponent(new Label(ErrorsUI.ERROR_MESSAGE));
                setContent(layout);
            }
        } else {
            VerticalLayout layout = new VerticalLayout();
            layout.addComponent(new Label(ErrorsUI.FATAL_ERROR));
            setContent(layout);
        }
    }
}
