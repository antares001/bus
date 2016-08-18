package net.scnetwork.bus.providers.bpay.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
interface IBPayService {
    @WebMethod(operationName = "testBpay")
    String test();
}
