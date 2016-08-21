package net.scnetwork.bus.ui;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import net.scnetwork.bus.ui.views.AccessDeniedView;
import net.scnetwork.bus.ui.views.ErrorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.security.VaadinSecurity;
import org.vaadin.spring.security.util.SecurityExceptionUtils;
import org.vaadin.spring.sidebar.components.ValoSideBar;
import org.vaadin.spring.sidebar.security.VaadinSecurityItemFilter;

@SpringUI
@Theme(ValoTheme.THEME_NAME)
@Push(transport = Transport.WEBSOCKET)
public class MainUI extends UI{
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private VaadinSecurity vaadinSecurity;

    @Autowired
    private SpringViewProvider springViewProvider;

    @Autowired
    private ValoSideBar sideBar;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Администрирование шины");
        setErrorHandler(new DefaultErrorHandler() {
            @Override
            public void error(com.vaadin.server.ErrorEvent event) {
                if (SecurityExceptionUtils.isAccessDeniedException(event.getThrowable())) {
                    Notification.show("Sorry, you don't have access to do that.");
                } else {
                    super.error(event);
                }
            }
        });

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();

        sideBar.setItemFilter(new VaadinSecurityItemFilter(vaadinSecurity));
        layout.addComponent(sideBar);

        CssLayout viewContainer = new CssLayout();
        viewContainer.setSizeFull();
        layout.addComponent(viewContainer);
        layout.setExpandRatio(viewContainer, 1f);

        Navigator navigator = new Navigator(this, viewContainer);

        springViewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
        navigator.addProvider(springViewProvider);
        navigator.setErrorView(ErrorView.class);
        navigator.navigateTo(navigator.getState());

        setContent(layout);
    }
}
