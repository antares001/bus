package net.scnetwork.bus.rest;

import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;

@RestController
public class Pay {
    @RequestMapping(value = "/rest/xml/pay/{service}", method = RequestMethod.POST)
    public Response payXml(@PathVariable(value = "service") String service,
                           @RequestParam(value = "sum") BigDecimal sum,
                           @RequestParam(value = "currency") int currency,
                           @RequestParam(value = "newdata", required = false) String newData){
        switch (service){
            default:
                break;
        }
        return XmlUtils.getError(StatusEnum.NULL);
    }

    @RequestMapping(value = "/rest/js/pay/{service}", method = RequestMethod.POST)
    public ResponseJs payJs(@PathVariable(value = "service") String service,
                            @RequestParam(value = "sum") BigDecimal sum,
                            @RequestParam(value = "currency") int currency,
                            @RequestParam(value = "newdata", required = false) String newData){
        switch (service){
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL);
    }
}
