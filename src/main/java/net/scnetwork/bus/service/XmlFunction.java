package net.scnetwork.bus.service;

import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.XmlUtils;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "net.scnetwork.bus.service.IXmlFunction")
public class XmlFunction implements IXmlFunction{
    @Override
    public Response getXml(@WebParam final Request request) {
        if (null == request){
            return XmlUtils.getError(StatusEnum.NULL);
        } else {
            Auth auth = request.getAuth();
            if (null == auth){
                return XmlUtils.getError(StatusEnum.NOT_AUTH);
            } else {
                //TODO: проверка авторизации пользователя

                Data data = request.getData();
                if (null == data){
                    return XmlUtils.getError(StatusEnum.FORMAT_ERROR);
                } else {
                    //TODO: передача на маршрутизатор
                    return XmlUtils.getError(StatusEnum.OK);
                }
            }
        }
    }

    @Override
    public ResponseJs getJson(@WebParam RequestJs request) {
        return null;
    }
}
