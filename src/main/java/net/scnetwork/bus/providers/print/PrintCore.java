package net.scnetwork.bus.providers.print;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.DataRequest;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
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
                return XmlUtils.getError(StatusEnum.OK);
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
                return JsonUtils.getError(StatusEnum.OK);
            } else {
                return JsonUtils.getError(StatusEnum.SERVICE_DISABLED);
            }
        } else {
            return JsonUtils.getError(StatusEnum.SERVICE_NOT_FOUND);
        }
    }
}
