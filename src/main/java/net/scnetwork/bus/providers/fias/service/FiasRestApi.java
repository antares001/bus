package net.scnetwork.bus.providers.fias.service;

import net.scnetwork.bus.clients.fias.DownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadService;
import net.scnetwork.bus.clients.fias.DownloadServiceSoap;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.fias.enums.FiasFormatEnum;
import net.scnetwork.bus.providers.fias.enums.FiasOperation;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

/**
 * Настройка модуля ФИАС
 */
@RestController
public class FiasRestApi implements RestApi{
    @Autowired
    private Fias fias;

    /**
     * Операции fias
     * @param type тип операции
     * @return данные
     */
    @RequestMapping(value = "/rest/modules/operation/{type}")
    public String operation(@PathVariable(value = "type") String type, @QueryParam(value = "format") String format){
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
                break;
            case SYNC:
                break;
            case MONGODB:
                break;
            case REDIS:
                break;
            default:
                break;
        }
        return type;
    }

    @RequestMapping(value = "/rest/api/modules/fias/get/info")
    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                return fias.toString();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") @NotNull Boolean use,
                             @RequestParam(value = "service") @NotNull String service,
                             @RequestParam(value = "url") @NotNull String url) {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                fias.setUse(use);
                fias.setService(service.toUpperCase());
                fias.setUrl(url);
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/get/use")
    @Override
    public boolean getUse() {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                return fias.isUse();
            }
        }
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/fias/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") @NotNull Boolean use) {
        Modules modules = Config.getModules();
        if (null != modules){
            Fias fias = modules.getFias();
            if (null != fias){
                fias.setUse(use);
                modules.setFias(fias);
                Config.setModules(modules);
                return true;
            }
        }
        return false;
    }
}
