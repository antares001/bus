package net.scnetwork.bus.utils;

import net.scnetwork.bus.domain.DataRespError;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseError;
import net.scnetwork.bus.enums.StatusEnum;

/**
 * Формирование XML
 */
public class XmlUtils {
    /**
     * Конструктор
     */
    private XmlUtils() {}

    /**
     * Формирование сообщения об ошибке в формате XML
     * @param status тип ошибки
     * @return XML сообщение
     */
    public static Response getError(StatusEnum status){
        ResponseError response = new ResponseError();
        response.setType(0);

        DataRespError data = new DataRespError(status);
        response.setData(data);

        return response;
    }
}
