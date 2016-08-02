package net.scnetwork.bus.providers.Leader;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.providers.IProviders;

public class LeaderCore implements IProviders{
    @Override
    public Response processingXml(Data data) {
        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        return null;
    }
}
