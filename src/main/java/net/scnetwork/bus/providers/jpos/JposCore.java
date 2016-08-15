package net.scnetwork.bus.providers.jpos;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.modules.Jpos;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.providers.IProviders;

/**
 * Обработка сервиса JPOS
 */
public class JposCore implements IProviders{
    private static final Jpos jpos = Config.getInstance().getModules().getJpos();

    @Override
    public Response processingXml(Data data) {
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
