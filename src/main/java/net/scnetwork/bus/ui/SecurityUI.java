package net.scnetwork.bus.ui;


import net.scnetwork.bus.utils.LogBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityUI extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable().
                exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/admin/login")).accessDeniedPage("/admin/accessDenied")
                .and().authorizeRequests()
                .antMatchers("/VAADIN/**", "/PUSH/**", "/UIDL/**", "/admin/login", "/admin/login/**", "/error/**", "/accessDenied/**", "/vaadinServlet/**", "/rest/**").permitAll()
                .antMatchers("/authorized", "/**").fullyAuthenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        try {
            auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        } catch (Exception e) {
            LogBus.writeLog(e);
        }
    }
}
