package net.scnetwork.bus;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.service.XmlFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.vaadin.spring.http.HttpService;
import org.vaadin.spring.security.annotation.EnableVaadinSharedSecurity;
import org.vaadin.spring.security.config.VaadinSharedSecurityConfiguration;
import org.vaadin.spring.security.shared.VaadinAuthenticationSuccessHandler;
import org.vaadin.spring.security.shared.VaadinSessionClosingLogoutHandler;
import org.vaadin.spring.security.shared.VaadinUrlAuthenticationSuccessHandler;
import org.vaadin.spring.security.web.VaadinRedirectStrategy;

import javax.xml.ws.Endpoint;

/**
 * Класс запуска приложения
 */
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class Bus implements CommandLineRunner{
    @Autowired
    private Global global;

    private static final Logger log = LoggerFactory.getLogger(Bus.class);

    /**
     * Точка запуска приложения spring boot
     * @param arg входящие параметры
     */
    public static void main(String... arg){
        SpringApplication.run(Bus.class, arg);
    }

    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
    @EnableVaadinSharedSecurity
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
                    .and()
                    .withUser("admin").password("admin").roles("ADMIN");
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.authorizeRequests().antMatchers("/login/**", "/rest/**").anonymous().antMatchers("/vaadinServlet/UIDL/**")
                    .permitAll().antMatchers("/vaadinServlet/HEARTBEAT/**").permitAll().anyRequest().authenticated();
            http.httpBasic().disable();
            http.formLogin().disable();
            http.logout().addLogoutHandler(new VaadinSessionClosingLogoutHandler()).logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout").permitAll();
            http.exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
            http.rememberMe().rememberMeServices(rememberMeServices()).key("myAppKey");
            http.sessionManagement().sessionAuthenticationStrategy(sessionAuthenticationStrategy());
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/VAADIN/**");
        }

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Bean
        public RememberMeServices rememberMeServices() {
            return new TokenBasedRememberMeServices("myAppKey", userDetailsService());
        }

        @Bean
        public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
            return new SessionFixationProtectionStrategy();
        }

        @Bean(name = VaadinSharedSecurityConfiguration.VAADIN_AUTHENTICATION_SUCCESS_HANDLER_BEAN)
        VaadinAuthenticationSuccessHandler vaadinAuthenticationSuccessHandler(HttpService httpService,
                                                                              VaadinRedirectStrategy vaadinRedirectStrategy) {
            return new VaadinUrlAuthenticationSuccessHandler(httpService, vaadinRedirectStrategy, "/");
        }
    }

    @Override
    public void run(String... strings) throws Exception {
        Endpoint.publish(global.getEndpoint(), new XmlFunction());

        Config.setInstance(global);
        log.info(global.getModules().getBpay().getService());
    }
}
