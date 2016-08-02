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
    public Response payXml(@PathVariable(value = "service") ServiceEnum service,
                           @RequestParam(value = "sum") BigDecimal sum,
                           @RequestParam(value = "currency") int currency,
                           @RequestParam(value = "newdata", required = false) String newData){
        switch (service){
            case ARTOSIS:
                break;
            case LEADER:
                break;
            case IDC:
                break;
            case FOREX:
                break;
            case QIWI:
                break;
            default:
                break;
        }
        return XmlUtils.getError(StatusEnum.NULL);
    }

    @RequestMapping(value = "/rest/js/pay/{service}", method = RequestMethod.POST)
    public ResponseJs payJs(@PathVariable(value = "service") ServiceEnum service,
                            @RequestParam(value = "sum") BigDecimal sum,
                            @RequestParam(value = "currency") int currency,
                            @RequestParam(value = "newdata", required = false) String newData){
        switch (service){
            case ARTOSIS:
                break;
            case LEADER:
                break;
            case IDC:
                break;
            case FOREX:
                break;
            case QIWI:
                break;
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL);
    }
}
