package net.scnetwork.bus.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.providers.qiwi.config.Qiwi;
import net.scnetwork.bus.providers.yandex.config.Yandex;
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
@ViewScope
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
                verticalLayout.setComponentAlignment(header1, Alignment.TOP_CENTER);

                HorizontalLayout urlLayout = new HorizontalLayout();

                tabSheet = new TabSheet();
                tabSheet.setStyleName(ValoTheme.TABSHEET_FRAMED);
                tabSheet.setStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);

                createBaseOption(global);
                createModules(global.getModules());
                createDatabases(global);

                urlLayout.addComponent(tabSheet);
                verticalLayout.addComponent(urlLayout);
                verticalLayout.setComponentAlignment(urlLayout, Alignment.TOP_CENTER);

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

    private void createBaseOption(Global global){
        VerticalLayout generalLayout = new VerticalLayout();
        generalLayout.addComponent(new Label("Точка входа"));
        tabSheet.addTab(generalLayout, "Основные настройки");
    }

    private void createModules(Modules modules){
        VerticalLayout modulesLayout = new VerticalLayout();

        Table table = new Table("Модули");
        table.setSelectable(true);
        table.setWidth(600f, Unit.PIXELS);
        table.addContainerProperty("Имя", String.class, null);
        table.addContainerProperty("Использование", Boolean.class, null);
        table.addContainerProperty("Тип сервиса", String.class, null);
        table.addContainerProperty("Адрес", String.class, null);

        BPay bPay = modules.getBpay();
        if (null != bPay) {
            table.addItem(new Object[]{BPay.DESCRIPTION, bPay.isUse(), bPay.getService(), bPay.getUrl()}, 0);
        }

        Yandex yandex = modules.getYandex();
        if (null != yandex) {
            table.addItem(new Object[]{Yandex.DESCRIPTION, yandex.isUse(), yandex.getService(), yandex.getUrl()}, 1);
        }

        Qiwi qiwi = modules.getQiwi();
        if (null != qiwi) {
            table.addItem(new Object[]{Qiwi.DESCRIPTION, qiwi.isUse(), qiwi.getService(), qiwi.getUrl()}, 2);
        }

        Leader leader = modules.getLeader();
        if (null != leader){
            table.addItem(new Object[]{Leader.DESRIPTION, leader.isUse(), leader.getService(), leader.getUrl()}, 3);
        }

        Fias fias = modules.getFias();
        if (null != fias){
            table.addItem(new Object[]{Fias.DESRIPTION, fias.isUse(), fias.getService(), fias.getUrl()}, 4);
        }

        modulesLayout.addComponent(table);
        modulesLayout.setComponentAlignment(table, Alignment.TOP_CENTER);
        tabSheet.addTab(modulesLayout, "Модули системы");
    }

    private void createDatabases(Global global){
        VerticalLayout databasesLayout = new VerticalLayout();
        databasesLayout.addComponent(new Label("Базы данных"));
        tabSheet.addTab(databasesLayout, "Базы данных системы");
    }
}
