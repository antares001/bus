package net.scnetwork.bus.ui.views;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.utils.LogBus;

/**
 * Страница ошибки
 */
public class ErrorView extends VerticalLayout implements View {

    private Label message;

    /**
     * Инициализация страницы
     */
    public ErrorView() {
        setMargin(true);
        message = new Label();
        addComponent(message);
        message.setSizeUndefined();
        message.addStyleName(ValoTheme.LABEL_FAILURE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        message.setValue(String.format("No such view: %s", event.getViewName()));
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
