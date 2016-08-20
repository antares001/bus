package net.scnetwork.bus.providers.beeline;

import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.providers.IProviders;

/**
 * Обработка запросов на сервис Beeline
 */
public class BeelineCore implements IProviders{
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
