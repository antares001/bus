package net.scnetwork.bus.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.ui.Section;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

@SpringView(name = "")
@SideBarItem(sectionId = Section.VIEWS, caption = "Стартовая страница", order = 0)
@FontAwesomeIcon(FontAwesome.HOME)
public class HomeView extends VerticalLayout implements View {
    public HomeView(){
        setSpacing(true);
        setMargin(true);

        Label header = new Label("Добро пожаловать в административную часть шины");
        header.setStyleName(ValoTheme.LABEL_H1);
        addComponent(header);

        Label body = new Label("<p>Инструкция</p>");
        body.setContentMode(ContentMode.HTML);
        addComponent(body);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        //
    }
}
