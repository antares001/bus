package net.scnetwork.bus.rest;

import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class Pay {
    @RequestMapping("/rest/xml/pay/{service}")
    public Response payXml(@PathParam("service") String service){
        switch (service){
            default:
                break;
        }
        return XmlUtils.getError(StatusEnum.NULL);
    }

    @RequestMapping("/rest/js/pay/{service}")
    public ResponseJs payJs(@PathParam("service") String service){
        switch (service){
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL);
    }
}
