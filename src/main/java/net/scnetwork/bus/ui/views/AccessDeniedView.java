package net.scnetwork.bus.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.utils.LogBus;

/**
 * Страница ограничения доступа
 */
@SpringComponent
@UIScope
public class AccessDeniedView extends VerticalLayout implements View{
    private Label message;

    /**
     * Инициализация страницы
     */
    public AccessDeniedView() {
        setMargin(true);
        message = new Label();
        addComponent(message);
        message.setSizeUndefined();
        message.addStyleName(ValoTheme.LABEL_FAILURE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        message.setValue(String.format("You do not have access to this view: %s", viewChangeEvent.getViewName()));
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
