package net.scnetwork.bus.providers.bpay.service;

import net.scnetwork.bus.domain.Response;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BpaySoap {
    public static final String NAMESPACE_URI = "http://bus.scnetwork.net";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "bpay")
    @ResponsePayload
    public Response getInfo(){
        return null;
    }
}
