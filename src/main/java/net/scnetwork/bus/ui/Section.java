package net.scnetwork.bus.ui;

import org.springframework.stereotype.Component;
import org.vaadin.spring.sidebar.annotation.SideBarSection;
import org.vaadin.spring.sidebar.annotation.SideBarSections;

@Component
@SideBarSections({
        @SideBarSection(id = Section.VIEWS, caption = "Просмотр"),
        @SideBarSection(id = Section.OPERATIONS, caption = "Операции")
})
public class Section {
    public static final String VIEWS = "views";
    public static final String OPERATIONS = "operations";
}
