package net.scnetwork.bus.plugins.print;

import net.scnetwork.bus.interfaces.IProviders;
import net.scnetwork.bus.interfaces.domian.DataJs;
import net.scnetwork.bus.interfaces.domian.DataRequest;
import net.scnetwork.bus.interfaces.domian.Response;
import net.scnetwork.bus.interfaces.domian.ResponseJs;

public class PrintCore implements IProviders{
    @Override
    public Response processingXml(DataRequest data) {
        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        return null;
    }
}
