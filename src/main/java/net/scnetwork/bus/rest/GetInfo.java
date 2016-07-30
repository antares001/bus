package net.scnetwork.bus.rest;

import net.scnetwork.bus.Dispatcher;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetInfo {
    private Dispatcher dispatcher = new Dispatcher();

    @RequestMapping("/rest/get/echo")
    public String echoGet(){
        return "test running";
    }

    @RequestMapping("/rest/getXml")
    public Response restGetXml(){
        return dispatcher.restXmlDispatcher("");
    }

    @RequestMapping("/rest/getJson")
    public ResponseJs restGetJson(){
        return dispatcher.restJsDispatcher("");
    }
}
