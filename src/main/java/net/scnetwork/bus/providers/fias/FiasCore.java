package net.scnetwork.bus.providers.fias;

import net.scnetwork.bus.clients.fias.ArrayOfDownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadService;
import net.scnetwork.bus.clients.fias.DownloadServiceSoap;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.fias.domain.DataReqFias;
import net.scnetwork.bus.providers.fias.domain.DataRespFias;
import net.scnetwork.bus.providers.fias.domain.FiasOptions;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.providers.fias.domain.ParamFias;
import net.scnetwork.bus.providers.fias.enums.FiasOperation;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.LogBus;
import net.scnetwork.bus.utils.XmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Обработка сервиса FIAS
 */
public class FiasCore implements IProviders{
    private DownloadServiceSoap serviceSoap;
    private Fias fias;

    /**
     * Иницмализация конфигурации и клиента
     */
    public FiasCore(){
        DownloadService service = new DownloadService();
        serviceSoap = service.getDownloadServiceSoap();
        try{
            fias = Config.getInstance().getModules().getFias();
        } catch (NullPointerException e){
            LogBus.writeLog(e);
        }
    }

    @Override
    public Response processingXml(Data data) {
        if (null != fias) {
            if (fias.isUse()) {
                UseEnum use = UseEnum.valueOf(fias.getService());
                switch (use) {
                    case LOCAL:
                        return localProcessingXml(data);
                    case REMOTE:
                        return remoteProcessingXml(data);
                    case NONE:
                        return XmlUtils.getError(StatusEnum.ERROR_CONFIG);
                    default:
                        break;
                }
            } else {
                return XmlUtils.getError(StatusEnum.SERVICE_DISABLED);
            }
        } else {
            return XmlUtils.getError(StatusEnum.SERVICE_NOT_FOUND);
        }
        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (null != fias){
            if (fias.isUse()){
                UseEnum use = UseEnum.valueOf(fias.getService());
                switch (use){
                    case LOCAL:
                        return localProcessingJson(data);
                    case REMOTE:
                        return remoteProcessingJson(data);
                    case NONE:
                        return JsonUtils.getError(StatusEnum.ERROR_CONFIG);
                    default:
                        break;
                }
                return null;
            } else {
                return JsonUtils.getError(StatusEnum.SERVICE_DISABLED);
            }
        } else {
            return JsonUtils.getError(StatusEnum.SERVICE_NOT_FOUND);
        }
    }

    @Override
    public Response localProcessingXml(Data data) {
        FiasOptions options = ((DataReqFias) data).getFiasOptions();
        if (null != options) {
            FiasOperation operation = options.getFiasOperation();
            if (null != operation) {
                switch (operation) {
                    case GET_URL:
                        DownloadFileInfo fileInfo = serviceSoap.getLastDownloadFileInfo();
                        if (null != fileInfo) {
                            Response response = new Response();
                            Data dataResponse = new DataRespFias();
                            dataResponse.setStatus(StatusEnum.OK);
                            dataResponse.setService(ServiceEnum.FIAS);
                            switch (options.getFormatEnum()) {
                                case DBF:
                                    dataResponse.setResult(fileInfo.getFiasCompleteDbfUrl());
                                    break;
                                case XML:
                                    dataResponse.setResult(fileInfo.getFiasCompleteXmlUrl());
                                    break;
                                case SEVEN_Z:
                                    dataResponse.setResult(fileInfo.getKladr47ZUrl());
                                    break;
                                case ARJ:
                                    dataResponse.setResult(fileInfo.getKladr4ArjUrl());
                                    break;
                                case TEXT:
                                    dataResponse.setResult(fileInfo.getTextVersion());
                                    break;
                                default:
                                    break;
                            }
                            response.setData(dataResponse);
                            return response;
                        } else {
                            return XmlUtils.getError(StatusEnum.ERROR);
                        }
                    case GET_ALL_URLS:
                        ArrayOfDownloadFileInfo array = serviceSoap.getAllDownloadFileInfo();
                        List<DownloadFileInfo> list = array.getDownloadFileInfo();
                        Response response = new Response();
                        DataRespFias dataResponse = new DataRespFias();
                        if (list.size() > 0) {
                            dataResponse.setStatus(StatusEnum.OK);
                            final List<ParamFias> params = new ArrayList<>();
                            list.forEach(e -> {
                                ParamFias param = new ParamFias();
                                param.setId(e.getVersionId());
                                switch (options.getFormatEnum()) {
                                    case TEXT:
                                        param.setUrl(e.getTextVersion());
                                        break;
                                    case ARJ:
                                        param.setUrl(e.getKladr4ArjUrl());
                                        break;
                                    case SEVEN_Z:
                                        param.setUrl(e.getKladr47ZUrl());
                                        break;
                                    case XML:
                                        param.setUrl(e.getFiasCompleteXmlUrl());
                                        break;
                                    case DBF:
                                        param.setUrl(e.getFiasCompleteDbfUrl());
                                        break;
                                    default:
                                        break;
                                }
                                params.add(param);
                            });
                            dataResponse.setParamList(params);
                        } else {
                            dataResponse.setStatus(StatusEnum.ERROR);
                        }
                        response.setData(dataResponse);
                        return response;
                    case MONGODB:
                    case REDIS:
                    case SYNC:
                    default:
                        break;
                }
            }
        }
        return new Response();
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
