package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.clients.fias.DownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadService;
import net.scnetwork.bus.clients.fias.DownloadServiceSoap;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.fias.enums.FiasFormatEnum;
import net.scnetwork.bus.providers.fias.enums.FiasOperation;
import net.scnetwork.bus.rest.RestApi;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.LogBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Настройка модуля ФИАС
 */
@RestController
public class FiasRestApi implements RestApi {
    @Autowired
    private Fias fias;

    /**
     * Операции fias
     * @param type тип операции
     * @return данные
     */
    @RequestMapping(value = "/rest/modules/operation/{type}")
    public String FiasOperation(@PathVariable(value = "type") String type, @QueryParam(value = "format") String format){
        DownloadService service = new DownloadService();
        DownloadServiceSoap serviceSoap = service.getDownloadServiceSoap();
        switch (FiasOperation.valueOf(type)){
            case GET_URL:
                DownloadFileInfo fileInfo = serviceSoap.getLastDownloadFileInfo();
                switch (FiasFormatEnum.valueOf(format)){
                    case ARJ:
                        return fileInfo.getKladr4ArjUrl();
                    case DBF:
                        return fileInfo.getFiasDeltaDbfUrl();
                    case SEVEN_Z:
                        return fileInfo.getKladr47ZUrl();
                    case TEXT:
                        return fileInfo.getTextVersion();
                    case XML:
                        return fileInfo.getFiasDeltaXmlUrl();
                    default:
                        break;
                }
                break;
            case GET_ALL_URLS:
            case SYNC:
            case MONGODB:
            case REDIS:
                LogBus.info(type);
                break;
            default:
                break;
        }
        return type;
    }


    @RequestMapping(value = "/rest/modules/fias/get/{parameter}")
    @Override
    public String getApi(@PathParam(value = "parameter/") @NotNull String parameter) {
        switch (parameter) {
            case "info":
                return getConfig();
            case "service":
                return getService();
            case "use":
                return String.valueOf(getUse());
            case "url":
                return getUrl();
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL).toString();
    }

    @Override
    public String getConfig() {
        if (null != fias) {
            return fias.toString();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    @Override
    public boolean getUse() {
        return null != fias && fias.isUse();
    }

    public String getService() {
        if (null != fias) {
            return fias.getService();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }

    public String getUrl() {
        if (null != fias) {
            return fias.getUrl();
        } else {
            return JsonUtils.getError(StatusEnum.NULL).toString();
        }
    }
}
