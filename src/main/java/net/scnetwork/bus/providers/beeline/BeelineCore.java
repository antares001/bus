package net.scnetwork.bus.providers.beeline;

import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.LogBus;

/**
 * Обработка запросов на сервис Beeline
 */
public class BeelineCore implements IProviders{
    @Override
    public Response processingXml(DataRequest data) {
        LogBus.info("Beeline.processingXml");
        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        LogBus.info("Beeline.processing");
        return null;
    }

    @Override
    public Response localProcessingXml(DataRequest data) {
        LogBus.info("Beeline.localProcessingXml");
        return null;
    }

    @Override
    public ResponseJs localProcessingJson(DataJs data) {
        LogBus.info("Beeline.localProcessingJson");
        return null;
    }

    @Override
    public Response remoteProcessingXml(DataRequest data) {
        LogBus.info("Beeline.remoteProcessingXml");
        return null;
    }

    @Override
    public ResponseJs remoteProcessingJson(DataJs data) {
        LogBus.info("Beeline.remoteProcessingJson");
        return null;
    }
}
