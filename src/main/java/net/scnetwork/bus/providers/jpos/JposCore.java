package net.scnetwork.bus.providers.jpos;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.providers.jpos.config.JposConfig;
import net.scnetwork.bus.utils.LogBus;

/**
 * Обработка сервиса JPOS
 */
public class JposCore implements IProviders{
    private JposConfig jpos;

    public JposCore(){
        try {
            jpos = Config.getInstance().getModules().getJpos();
        } catch (NullPointerException e) {
            LogBus.writeLog(e);
        }
    }

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
