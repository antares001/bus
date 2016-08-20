package net.scnetwork.bus.ui.controller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.ui.util.ErrorsUI;

@SpringUI(path = "/admin/login")
@Title("Авторизация")
@Theme("valo")
public class LoginController extends UI{
    public static final String PAGE = "login";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Global global = Config.getInstance();
        if (null != global) {
            if (global.isGui()){
                VerticalLayout layout = new VerticalLayout();
                TextField username = new TextField("Имя пользователя");
                PasswordField password = new PasswordField("Пароль");
                Button login = new Button("Войти ", FontAwesome.ARROW_RIGHT);
                Button cancel = new Button("Очистить", FontAwesome.TRASH_O);
                CssLayout cssLayout = new CssLayout(login, cancel);

                layout.addComponents(username, password, cssLayout);

                layout.setSpacing(true);
                layout.setMargin(true);
                cssLayout.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
                login.setStyleName(ValoTheme.BUTTON_PRIMARY);
                login.setClickShortcut(ShortcutAction.KeyCode.ENTER);

                login.addClickListener(e -> Notification.show("login"));
                cancel.addClickListener(e -> {
                    username.setValue("");
                    password.setValue("");
                });

                layout.setComponentAlignment(username, Alignment.TOP_CENTER);
                layout.setComponentAlignment(password, Alignment.TOP_CENTER);
                layout.setComponentAlignment(cssLayout, Alignment.TOP_CENTER);
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
