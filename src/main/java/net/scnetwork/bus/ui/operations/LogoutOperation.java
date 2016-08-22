package net.scnetwork.bus.ui.operations;

import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import net.scnetwork.bus.ui.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.security.VaadinSecurity;
import org.vaadin.spring.sidebar.annotation.FontAwesomeIcon;
import org.vaadin.spring.sidebar.annotation.SideBarItem;

/**
 * Операция выход из системы
 */
@SpringComponent
@SideBarItem(sectionId = Section.OPERATIONS, caption = "Выход")
@FontAwesomeIcon(FontAwesome.POWER_OFF)
public class LogoutOperation implements Runnable{
    private final VaadinSecurity vaadinSecurity;

    @Autowired
    public LogoutOperation(VaadinSecurity vaadinSecurity){
        this.vaadinSecurity = vaadinSecurity;
    }

    @Override
    public void run() {
        vaadinSecurity.logout();
    }
}
