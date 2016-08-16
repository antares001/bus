package net.scnetwork.bus.providers.forex;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.providers.forex.domain.DataRespForex;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;

import java.util.Date;

/**
 * Обработка сервиса FOREX
 */
public class ForexCore implements IProviders{
    @Override
    public Response processingXml(Data data){
        Response result = new Response();

        Data rData = new DataRespForex();
        rData.setStatus(StatusEnum.OK);
        result.setData(rData);

        return result;
    }

    @Override
    public ResponseJs processing(DataJs data){
        ResponseJs result = new ResponseJs();

        DataJs rData = new DataJs();
        rData.setDate(new Date());
        rData.setStatus(StatusEnum.OK);
        result.setData(rData);

        return result;
    }

    @Override
    public Response localProcessingXml(Data data) {
        return null;
    }

    @Override
    public ResponseJs localProcessingJson(DataJs data) {
        return null;
    }

    @Override
    public Response remoteProcessingXml(Data data) {
        return null;
    }

    @Override
    public ResponseJs remoteProcessingJson(DataJs data) {
        return null;
    }
}
