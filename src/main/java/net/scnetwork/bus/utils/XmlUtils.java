package net.scnetwork.bus.utils;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataResponse.DataRespError;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.enums.StatusEnum;

public class XmlUtils {
    public static Response getError(StatusEnum status){
        Response response = new Response();
        response.setType(0);

        Data data = new DataRespError(status);
        response.setData(data);

        return response;
    }
}
