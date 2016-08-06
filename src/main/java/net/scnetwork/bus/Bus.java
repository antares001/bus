package net.scnetwork.bus;

import net.scnetwork.bus.config.modules.BPay;
import net.scnetwork.bus.service.XmlFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
public class Bus implements CommandLineRunner{
    public static void main(String... arg){
        SpringApplication.run(Bus.class, arg);
    }

    @Override
    public void run(String... strings) throws Exception {
        Endpoint.publish("http://127.0.0.1:8090/soap", new XmlFunction());
    }
}
