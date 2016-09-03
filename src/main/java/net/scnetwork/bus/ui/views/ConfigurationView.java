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
import net.scnetwork.bus.enums.DaoEnums;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.forex.config.Forex;
import net.scnetwork.bus.providers.jpos.config.JposConfig;
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
        LogBus.info("ViewConfig=>equals");
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        int hash = 37;
        hash = hash*17 + tabSheet.hashCode();

        return hash;
    }

    private void createBaseOption(Global global){
        VerticalLayout generalLayout = new VerticalLayout();
        LogBus.info(global.toString());
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

        JposConfig jpos = modules.getJpos();
        if (null != jpos){
            table.addItem(new Object[]{JposConfig.DESCRIPTION, jpos.isUse(), jpos.getService(), jpos.getUrl()}, 5);
        }

        Forex forex = modules.getForex();
        if (null != forex){
            table.addItem(new Object[]{Forex.DESCRIPTION, forex.isUse(), forex.getService(), forex.getUrl()}, 6);
        }

        modulesLayout.addComponent(table);
        modulesLayout.setComponentAlignment(table, Alignment.TOP_CENTER);

        HorizontalLayout buttonLayout = new HorizontalLayout();
        Button edit = new Button("Редактировать");
        edit.setEnabled(false);
        edit.addClickListener(e -> Notification.show("Edit click"));

        Button view = new Button("Просмотр");
        view.setEnabled(false);
        view.addClickListener(e -> Notification.show("View click"));

        Button disable = new Button("Отключить");
        disable.setEnabled(false);
        disable.addClickListener(e -> Notification.show("Disable click"));

        table.addItemSetChangeListener(e -> {
            edit.setEnabled(true);
            view.setEnabled(true);
            disable.setEnabled(true);
        });

        buttonLayout.setSpacing(true);
        buttonLayout.setMargin(true);

        buttonLayout.addComponent(edit);
        buttonLayout.addComponent(view);
        buttonLayout.addComponent(disable);

        modulesLayout.addComponent(buttonLayout);
        modulesLayout.setComponentAlignment(buttonLayout, Alignment.TOP_CENTER);

        tabSheet.addTab(modulesLayout, "Модули системы");
    }

    private void createDatabases(Global global){
        VerticalLayout databasesLayout = new VerticalLayout();

        if (null != global){
            DaoEnums dao = global.getDao();
            LogBus.info(dao.getName());
        }
        tabSheet.addTab(databasesLayout, "Базы данных системы");
    }
}
