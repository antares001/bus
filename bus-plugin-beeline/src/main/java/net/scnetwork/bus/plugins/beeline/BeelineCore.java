package net.scnetwork.bus.plugins.beeline;

import net.scnetwork.bus.interfaces.IProvidersStadard;
import net.scnetwork.bus.interfaces.domian.DataJs;
import net.scnetwork.bus.interfaces.domian.DataRequest;
import net.scnetwork.bus.interfaces.domian.Response;
import net.scnetwork.bus.interfaces.domian.ResponseJs;

public class BeelineCore implements IProvidersStadard{
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
