package net.scnetwork.bus.ui.controller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI(path = "/admin/main")
@Title("Конфигурация")
@Theme("valo")
public class MainController extends UI{
    public static final String PAGE = "main";

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label(PAGE));
    }
}
