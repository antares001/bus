package net.scnetwork.bus.utils;

import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;

public class JsonUtils {
    public static ResponseJs getError(StatusEnum status){
        ResponseJs result = new ResponseJs();
        DataJs data = new DataJs();
        data.setStatus(status);
        result.setData(data);

        return result;
    }
}
