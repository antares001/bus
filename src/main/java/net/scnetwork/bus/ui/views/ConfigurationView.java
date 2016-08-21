package net.scnetwork.bus.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.ui.Section;
import net.scnetwork.bus.utils.LogBus;
import org.springframework.security.access.annotation.Secured;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

/**
 * Форма отображения конфигурации шины
 */
@Secured({"ROLE_USER", "ROLE_ADMIN"})
@SpringView(name = "config")
@SideBarItem(sectionId = Section.VIEWS, caption = "Конфигурация шины", order = 1)
@FontAwesomeIcon(FontAwesome.BANK)
public class ConfigurationView extends VerticalLayout implements View{
    public ConfigurationView(){
        try {
            setSpacing(true);
            setMargin(true);

            Global global = Config.getInstance();
            if (null != global) {
                Label header1 = new Label("Конфигурация");
                header1.setStyleName(ValoTheme.LABEL_H1);
                addComponent(header1);
            } else {
                Label error = new Label("Ошибка конфигурации");
                error.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                addComponent(error);
            }
        } catch (Exception e){
            LogBus.writeLog(e);
        }
    }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        LogBus.info("enter config");
    }
}
