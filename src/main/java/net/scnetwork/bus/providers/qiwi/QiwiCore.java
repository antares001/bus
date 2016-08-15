package net.scnetwork.bus.providers.qiwi;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.modules.Qiwi;
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
 * Обработка сервиса Qiwi
 */
public class QiwiCore implements IProviders{
    private Qiwi qiwi = Config.getInstance().getModules().getQiwi();

    @Override
    public Response processingXml(Data data) {
        if (qiwi.isUse()) {
            switch (UseEnum.valueOf(qiwi.getService())){
                case LOCAL:
                case REMOTE:
                case NONE:
                default:
                    return XmlUtils.getError(StatusEnum.ERROR_CONFIG);
            }
        } else {
            return XmlUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (qiwi.isUse()) {
            switch (UseEnum.valueOf(qiwi.getService())){
                case LOCAL:
                case REMOTE:
                case NONE:
                default:
                    return JsonUtils.getError(StatusEnum.ERROR_CONFIG);
            }
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
