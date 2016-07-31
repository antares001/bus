package net.scnetwork.bus.rest;

import net.scnetwork.bus.Dispatcher;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetInfo {
    private Dispatcher dispatcher = new Dispatcher();

    @RequestMapping(value = "/rest/get/echo", method = RequestMethod.GET)
    public String echoGet(){
        return "test running";
    }

    @RequestMapping("/rest/getXml/{service}")
    public Response restGetXml(@PathVariable(value = "service") String service,
                               @RequestParam(value = "account") String account){
        switch (service){
            default:
                break;
        }
        return dispatcher.restXmlDispatcher("");
    }

    @RequestMapping(value = "/rest/getJson/{service}", method = RequestMethod.GET)
    public ResponseJs restGetJson(@PathVariable(value = "service") String service,
                                  @RequestParam(value = "account") String account){
        switch (service){
            default:
                break;
        }
        return dispatcher.restJsDispatcher("");
    }
}
