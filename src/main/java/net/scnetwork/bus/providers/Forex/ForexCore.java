package net.scnetwork.bus.providers.Forex;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;

public class ForexCore {
    public Response processingXml(Data data){
        Response result = new Response();

        String account = data.getAccount();

        Data rData = new Data();
        result.setData(rData);

        return result;
    }

    public ResponseJs processing(DataJs data){
        ResponseJs result = new ResponseJs();

        String account = data.getAccount();

        DataJs rData = new DataJs();
        result.setData(rData);

        return result;
    }
}
