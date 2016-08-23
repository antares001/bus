package net.scnetwork.bus.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
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
public class ConfigurationView extends CustomComponent implements View{
    private TabSheet tabSheet;

    /**
     * Инициализация
     */
    public ConfigurationView(){
        try {
            Global global = Config.getInstance();
            if (null != global) {
                VerticalLayout verticalLayout = new VerticalLayout();
                Label header1 = new Label("Конфигурация");
                header1.setStyleName(ValoTheme.LABEL_H1);
                verticalLayout.addComponent(header1);

                HorizontalLayout urlLayout = new HorizontalLayout();

                tabSheet = new TabSheet();
                tabSheet.setStyleName(ValoTheme.TABSHEET_FRAMED);
                tabSheet.setStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

                createBaseOption();
                createModules();
                createDatabases();

                urlLayout.addComponent(tabSheet);
                verticalLayout.addComponent(urlLayout);

                setCompositionRoot(verticalLayout);
            } else {
                Label error = new Label("Ошибка конфигурации");
                error.setStyleName(ValoTheme.NOTIFICATION_ERROR);
                setCompositionRoot(error);
            }
        } catch (Exception e){
            LogBus.writeLog(e);
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        LogBus.info("enter config");
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    private void createBaseOption(){
        VerticalLayout generalLayout = new VerticalLayout();
        generalLayout.addComponent(new Label("Точка входа"));
        tabSheet.addTab(generalLayout, "Основные настройки");
    }

    private void createModules(){
        VerticalLayout modulesLayout = new VerticalLayout();
        modulesLayout.addComponent(new Label("Модули"));
        tabSheet.addTab(modulesLayout, "Модули системы");
    }

    private void createDatabases(){
        VerticalLayout databasesLayout = new VerticalLayout();
        databasesLayout.addComponent(new Label("Базы данных"));
        tabSheet.addTab(databasesLayout, "Базы данных системы");
    }
}
