package net.scnetwork.bus.providers.Forex;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ForexCore {
    public Response processingXml(Data data){
        Response result = new Response();

        String account = data.getAccount();

        Data rData = new Data();
        rData.setDate(new Date());
        rData.setStatus(StatusEnum.OK);
        result.setData(rData);

        return result;
    }

    public ResponseJs processing(DataJs data){
        ResponseJs result = new ResponseJs();

        String account = data.getAccount();

        DataJs rData = new DataJs();
        rData.setDate(new Date());
        rData.setStatus(StatusEnum.OK);
        result.setData(rData);

        return result;
    }
}
