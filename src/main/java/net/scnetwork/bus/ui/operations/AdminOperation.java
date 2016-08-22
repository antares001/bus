package net.scnetwork.bus.ui.operations;

import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Notification;
import net.scnetwork.bus.ui.Section;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

/**
 * Операции
 */
@SpringComponent
@SideBarItem(sectionId = Section.OPERATIONS, caption = "Администрирование шины", order = 0)
@FontAwesomeIcon(FontAwesome.WRENCH)
public class AdminOperation implements Runnable{
    @Override
    public void run() {
        Notification.show("Hello admin");
    }
}
