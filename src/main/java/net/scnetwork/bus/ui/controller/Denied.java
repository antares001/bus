package net.scnetwork.bus.ui.controller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI(path = "/admin/accessDenied")
@Theme(ValoTheme.THEME_NAME)
@Title("Доступ запрещен")
public class Denied extends UI{
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label("Access Denied"));
    }
}
