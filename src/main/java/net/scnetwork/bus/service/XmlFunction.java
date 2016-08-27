package net.scnetwork.bus.service;

import net.scnetwork.bus.Dispatcher;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Единая точка входа
 */
@WebService(endpointInterface = "net.scnetwork.bus.service.IXmlFunction")
public class XmlFunction implements IXmlFunction{
    private Dispatcher dispatcher = new Dispatcher();

    @Override
    public Response getXml(@WebParam final Request request) {
        if (null == request){
            return XmlUtils.getError(StatusEnum.NULL);
        } else {
            Auth auth = request.getAuth();
            if (null == auth){
                return XmlUtils.getError(StatusEnum.NOT_AUTH);
            } else {
                Data data = request.getData();
                if (null == data){
                    return XmlUtils.getError(StatusEnum.FORMAT_ERROR);
                } else {
                    return dispatcher.soapXmlDispatcher((DataRequest) data, auth.getService());
                }
            }
        }
    }

    @Override
    public ResponseJs getJson(@WebParam RequestJs request) {
        if(null == request){
            return JsonUtils.getError(StatusEnum.NULL);
        } else {
            AuthJs auth = request.getAuth();
            if (null == auth){
                return JsonUtils.getError(StatusEnum.NOT_AUTH);
            } else {
                DataJs data = request.getData();
                if (null == data){
                    return JsonUtils.getError(StatusEnum.FORMAT_ERROR);
                } else {
                    return dispatcher.soapJsDispatcher(data, auth.getService());
                }
            }
        }
    }
}
