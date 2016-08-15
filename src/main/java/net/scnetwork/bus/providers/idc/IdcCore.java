package net.scnetwork.bus.providers.idc;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.modules.Idc;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

/**
 * Обработка сервиса IDC
 */
public class IdcCore implements IProviders{
    private Idc idc = Config.getInstance().getModules().getIdc();

    @Override
    public Response processingXml(Data data) {
        if (idc.isUse()) {
            switch (UseEnum.valueOf(idc.getService())){
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
            switch (UseEnum.valueOf(idc.getService())){
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
