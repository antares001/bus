package net.scnetwork.bus.providers.Fias;

import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.providers.IProviders;

public class FiasCore implements IProviders{
    @Override
    public Response processingXml(Data data) {
        FiasOptions options = data.getFiasOptions();
        if (null != options){
            FiasOperation operation = options.getFiasOperation();
            if (null != operation){
                switch (operation){
                    case GET_URL:
                        break;
                    default:
                        break;
                }
            }
        }
        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        return null;
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
