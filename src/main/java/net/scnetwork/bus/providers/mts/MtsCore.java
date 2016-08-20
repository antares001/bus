package net.scnetwork.bus.providers.mts;

import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.providers.IProviders;

/**
 * Обработка сервиса МТС
 */
public class MtsCore implements IProviders{
    @Override
    public Response processingXml(DataRequest data) {
        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        return null;
    }

    @Override
    public Response localProcessingXml(DataRequest data) {
        return null;
    }

    @Override
    public ResponseJs localProcessingJson(DataJs data) {
        return null;
    }

    @Override
    public Response remoteProcessingXml(DataRequest data) {
        return null;
    }

    @Override
    public ResponseJs remoteProcessingJson(DataJs data) {
        return null;
    }
}
