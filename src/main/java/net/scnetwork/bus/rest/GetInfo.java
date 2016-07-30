package net.scnetwork.bus.rest;

import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetInfo {
    @RequestMapping("/rest/get/echo")
    public String echoGet(){
        return "test running";
    }

    @RequestMapping("/rest/getXml")
    public Response restGetXml(){
        return XmlUtils.getError(StatusEnum.FORMAT_ERROR);
    }
}
