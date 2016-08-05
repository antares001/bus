package net.scnetwork.bus.providers.Qiwi;

import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class QiwiCore implements IProviders{
    @Autowired
    private Modules modules;

    @Override
    public Response processingXml(Data data) {
        if (modules.isQiwi()) {
            return null;
        } else {
            return XmlUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (modules.isQiwi()) {
            return null;
        } else {
            return JsonUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }
}
