package net.scnetwork.bus.utils;

import net.scnetwork.bus.domain.DataJsError;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;

/**
 * Формирование JSON сообщений
 */
public class JsonUtils {
    private JsonUtils(){}

    /**
     * Формирование сообщения об ошибке в формате JSON
     * @param status тип ошибки
     * @return JSON сообщение
     */
    public static ResponseJs getError(StatusEnum status){
        ResponseJs result = new ResponseJs();
        DataJsError data = new DataJsError();
        data.setStatus(status);
        result.setData(data);

        return result;
    }
}
