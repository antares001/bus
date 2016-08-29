package net.scnetwork.bus.providers.forex;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.providers.forex.config.Forex;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.LogBus;
import net.scnetwork.bus.utils.XmlUtils;

/**
 * Обработка сервиса FOREX
 */
public class ForexCore implements IProviders{
    private Forex forex;

    /**
     * Иницализация конфигурации сервиса
     */
    public ForexCore(){
        try{
            forex = Config.getInstance().getModules().getForex();
        } catch (NullPointerException e){
            LogBus.writeLog(e);
        }
    }

    @Override
    public Response processingXml(DataRequest data){
        if (null != forex){
            if (forex.isUse()){
                UseEnum use = UseEnum.valueOf(forex.getService());
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
    public ResponseJs processing(DataJs data){
        if (null != forex){
            if (forex.isUse()){
                UseEnum use = UseEnum.valueOf(forex.getService());
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
