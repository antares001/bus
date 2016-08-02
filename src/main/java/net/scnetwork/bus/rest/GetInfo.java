package net.scnetwork.bus.rest;

import net.scnetwork.bus.Dispatcher;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.Forex.ForexCore;
import net.scnetwork.bus.providers.Qiwi.QiwiCore;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RestController
public class GetInfo {
    private Dispatcher dispatcher = new Dispatcher();

    @RequestMapping(value = "/rest/get/echo", method = RequestMethod.GET)
    public String echoGet(){
        return "test running";
    }

    @RequestMapping("/rest/getXml/{service}")
    public Response restGetXml(@PathVariable(value = "service") ServiceEnum service,
                               @RequestParam(value = "account") String account){
        Data data = new Data();
        data.setAccount(account);
        data.setOperation(service);
        switch (service){
            case FOREX:
                ForexCore fix = new ForexCore();
                return fix.processingXml(data);
            case QIWI:
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processingXml(data);
            default:
                break;
        }
        return dispatcher.restXmlDispatcher("");
    }

    @RequestMapping(value = "/rest/getJson/{service}", method = RequestMethod.GET)
    public ResponseJs restGetJson(@PathVariable(value = "service") ServiceEnum service,
                                  @RequestParam(value = "account") String account){
        DataJs data = new DataJs();
        data.setAccount(account);
        switch (service){
            case QIWI:
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processing(data);
            case FOREX:
                ForexCore fix = new ForexCore();
                return fix.processing(data);
            default:
                break;
        }
        return dispatcher.restJsDispatcher("");
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(ServiceEnum.class, new ServiceConverter());
    }
}
