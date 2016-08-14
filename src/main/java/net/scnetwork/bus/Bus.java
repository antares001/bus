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

import javax.xml.ws.Endpoint;

@SpringBootApplication
/**
 * Класс запуска приложения
 */
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

    @Override
    public void run(String... strings) throws Exception {
        Endpoint.publish(global.getEndpoint(), new XmlFunction());
        Config.setInstance(global);
        log.info(global.getModules().getBpay().getService());
    }
}
