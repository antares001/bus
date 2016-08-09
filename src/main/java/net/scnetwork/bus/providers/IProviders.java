package net.scnetwork.bus.providers;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;

public interface IProviders {
    Response processingXml(Data data);
    ResponseJs processing(DataJs data);

    Response localProcessingXml(Data data);
    ResponseJs localProcessingJson(DataJs data);

    Response remoteProcessingXml(Data data);
    ResponseJs remoteProcessingJson(DataJs data);
}
