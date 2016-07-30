package net.scnetwork.bus.rest;

import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.web.bind.annotation.RequestMapping;

public class Pay {
    @RequestMapping("/rest/xml/pay")
    public Response payXml(){
        return XmlUtils.getError(StatusEnum.NULL);
    }

    @RequestMapping("/rest/js/pay")
    public ResponseJs payJs(){
        return JsonUtils.getError(StatusEnum.NULL);
    }
}
