package net.scnetwork.bus.providers.bpay.ws;

import net.scnetwork.bus.enums.StatusEnum;

import javax.jws.WebService;

@WebService(endpointInterface = "net.scnetwork.bus.providers.bpay.ws.IBPayService")
public class BPayService implements IBPayService{
    @Override
    public String test() {
        return StatusEnum.OK.getName();
    }
}
