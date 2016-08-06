package net.scnetwork.bus.providers.Idc;

import net.scnetwork.bus.config.modules.Idc;
import net.scnetwork.bus.config.modules.Modules;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class IdcCore implements IProviders{
    @Autowired
    private Idc idc;

    @Override
    public Response processingXml(Data data) {
        if (idc.isUse()) {
            switch (idc.getUseEnum()){
                case LOCAL:
                    String point = idc.getPoint();
                    break;
                case REMOTE:
                    String microservice = idc.getUrl();
                    break;
                case NONE:
                    break;
                default:
                    return XmlUtils.getError(StatusEnum.ERROR_CONFIG);
            }
            return null;
        } else {
            return XmlUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (idc.isUse()) {
            switch (idc.getUseEnum()){
                case LOCAL:
                    String point = idc.getPoint();
                    break;
                case REMOTE:
                    String microservice = idc.getUrl();
                    break;
                case NONE:
                    break;
                default:
                    return JsonUtils.getError(StatusEnum.ERROR_CONFIG);
            }
            return null;
        } else {
            return JsonUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }
}
