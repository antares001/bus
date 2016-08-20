package net.scnetwork.bus.service;

import net.scnetwork.bus.domain.Request;
import net.scnetwork.bus.domain.RequestJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Сервис
 */
@WebService
public interface IXmlFunction {
    /**
     * Операции в формате XML
     * @param request запрос в формате XML
     * @return ответ в формате XML
     */
    @WebMethod(operationName = "getXml")
    Response getXml(@WebParam final Request request);

    /**
     * Операции в формате JSON
     * @param request запрос в формате JSON
     * @return ответ в формате JSON
     */
    @WebMethod(operationName = "getJson")
    ResponseJs getJson(@WebParam final RequestJs request);
}
