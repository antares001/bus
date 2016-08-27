package net.scnetwork.bus.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.ui.Section;
import net.scnetwork.bus.utils.LogBus;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

/**
 * Страница графиков
 */
@SpringView(name = "chart")
@SideBarItem(sectionId = Section.VIEWS, caption = "Графики", order = 2)
@FontAwesomeIcon(FontAwesome.BAR_CHART_O)
@ViewScope
public class ChartView extends CustomComponent implements View{

    /**
     * Инициализация
     */
    public ChartView(){
        Label label = new Label("Графики");
        label.setStyleName(ValoTheme.LABEL_H1);
        setCompositionRoot(label);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        LogBus.info("chart");
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
