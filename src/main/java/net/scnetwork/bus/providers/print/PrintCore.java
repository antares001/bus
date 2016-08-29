package net.scnetwork.bus.providers.print;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.providers.print.config.Print;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.LogBus;
import net.scnetwork.bus.utils.XmlUtils;

/**
 * Обработка сервиса печати
 */
public class PrintCore implements IProviders{
    private Print print;

    /**
     * Иницализация конфигурации сервиса
     */
    public PrintCore(){
        try{
            Modules modules = Config.getModules();
            if (null != modules) {
                print = modules.getPrint();
            }
        } catch (NullPointerException e){
            LogBus.writeLog(e);
        }
    }

    @Override
    public Response processingXml(DataRequest data) {
        if (null != print){
            if (print.isUse()){
                UseEnum use = UseEnum.valueOf(print.getService());
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
        if (null != print){
            if (print.isUse()){
                UseEnum use = UseEnum.valueOf(print.getService());
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
