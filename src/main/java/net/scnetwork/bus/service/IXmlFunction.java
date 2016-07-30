package net.scnetwork.bus.service;

import net.scnetwork.bus.domain.Request;
import net.scnetwork.bus.domain.RequestJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IXmlFunction {
    @WebMethod(operationName = "getXml")
    Response getXml(@WebParam final Request request);

    @WebMethod(operationName = "getJson")
    ResponseJs getJson(@WebParam final RequestJs request);
}
