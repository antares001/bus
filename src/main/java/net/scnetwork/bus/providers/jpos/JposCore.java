package net.scnetwork.bus.providers.jpos;

import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.DataRequest;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProvidersStadard;
import net.scnetwork.bus.providers.jpos.config.Jpos;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

/**
 * Обработка сервиса JPOS
 */
public class JposCore implements IProvidersStadard{
    private Jpos jpos;

    /**
     * Инициализация конфигурации
     * @param config - конфигурация сервиса
     */
    public JposCore(Jpos config){
        this.jpos = config;
    }

    @Override
    public Response processingXml(DataRequest data) {
        if (null != jpos){
            if (jpos.isUse()){
                UseEnum use = UseEnum.valueOf(jpos.getService());
                switch (use){
                    case LOCAL:
                        return localProcessingXml(data);
                    case REMOTE:
                        return remoteProcessingXml(data);
                    default:
                        return XmlUtils.getError(StatusEnum.ERROR_CONFIG);
                }
            } else {
                return XmlUtils.getError(StatusEnum.SERVICE_DISABLED);
            }
        } else {
            return XmlUtils.getError(StatusEnum.SERVICE_NOT_FOUND);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (null != jpos){
            if (jpos.isUse()){
                UseEnum use = UseEnum.valueOf(jpos.getService());
                switch (use){
                    case LOCAL:
                        return localProcessingJson(data);
                    case REMOTE:
                        return remoteProcessingJson(data);
                    default:
                        return JsonUtils.getError(StatusEnum.ERROR_CONFIG);
                }
            } else {
                return JsonUtils.getError(StatusEnum.SERVICE_DISABLED);
            }
        } else {
            return JsonUtils.getError(StatusEnum.SERVICE_NOT_FOUND);
        }
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
