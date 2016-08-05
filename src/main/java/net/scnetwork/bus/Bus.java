package net.scnetwork.bus;

import net.scnetwork.bus.service.XmlFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class Bus implements CommandLineRunner{
    private static final Logger log = LoggerFactory.getLogger(Bus.class);

    public static void main(String... arg){
        SpringApplication.run(Bus.class, arg);
    }

    @Override
    public void run(String... strings) throws Exception {
        Endpoint.publish("http://127.0.0.1:8090/soap", new XmlFunction());
    }
}
