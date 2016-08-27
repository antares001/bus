package net.scnetwork.bus.ui;


import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.utils.LogBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.security.shared.VaadinSharedSecurity;

/**
 * Форма для авторизации
 */
@SpringUI(path = "/login")
@Theme(ValoTheme.THEME_NAME)
public class LoginUI extends UI {

    @Autowired
    private transient VaadinSharedSecurity vaadinSecurity;

    private TextField userName;
    private PasswordField passwordField;
    private CheckBox rememberMe;
    private Button login;
    private Label loginFailed;
    private Label loggedOut;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Авторизация в системе");

        FormLayout loginForm = new FormLayout();
        loginForm.setSizeUndefined();

        userName = new TextField("Пользователь");
        passwordField = new PasswordField("Пароль");
        rememberMe = new CheckBox("Запомнить");
        login = new Button("Войти", FontAwesome.ARROW_RIGHT);

        loginForm.addComponent(userName);
        loginForm.addComponent(passwordField);
        loginForm.addComponent(rememberMe);
        loginForm.addComponent(login);

        login.setStyleName(ValoTheme.BUTTON_PRIMARY);
        login.setDisableOnClick(true);
        login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        login.addClickListener(e -> {
            try{
                vaadinSecurity.login(userName.getValue(), passwordField.getValue(), rememberMe.getValue());
            } catch (Exception e1) {
                userName.focus();
                userName.selectAll();
                passwordField.setValue("");
                loginFailed.setValue(String.format("Login failed: %s", e1.getMessage()));
                LogBus.writeLog(e1);
                loginFailed.setVisible(true);

                if (loggedOut != null) {
                    loggedOut.setVisible(false);
                }
            } finally {
                login.setEnabled(true);
            }
        });

        VerticalLayout loginLayout = new VerticalLayout();
        loginLayout.setSpacing(true);
        loginLayout.setSizeUndefined();

        if (null != vaadinRequest.getParameter("logout")){
            loggedOut = new Label("You have been logged out!");
            loggedOut.addStyleName(ValoTheme.LABEL_SUCCESS);
            loggedOut.setSizeUndefined();
            loginLayout.addComponent(loggedOut);
            loginLayout.setComponentAlignment(loggedOut, Alignment.BOTTOM_CENTER);
        }

        loginFailed = new Label();
        loginLayout.addComponent(loginFailed);
        loginLayout.setComponentAlignment(loginFailed, Alignment.BOTTOM_CENTER);
        loginFailed.setSizeUndefined();
        loginFailed.addStyleName(ValoTheme.LABEL_FAILURE);
        loginFailed.setVisible(false);

        loginLayout.addComponent(loginForm);
        loginLayout.setComponentAlignment(loginForm, Alignment.TOP_CENTER);

        VerticalLayout rootLayout = new VerticalLayout(loginLayout);
        rootLayout.setSizeFull();
        rootLayout.setComponentAlignment(loginLayout, Alignment.MIDDLE_CENTER);
        setContent(rootLayout);
        setSizeFull();
    }

    @Override
    public boolean equals(Object o){
        LogBus.info("");
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        LogBus.info("");
        return super.hashCode();
    }
}