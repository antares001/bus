package net.scnetwork.bus.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI(path = "/admin")
@Theme("valo")
public class WebUI extends UI{
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Button("Click", e -> Notification.show("hello")));
    }
}
