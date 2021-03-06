package net.scnetwork.bus.providers.fias;

import net.scnetwork.bus.clients.fias.ArrayOfDownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadService;
import net.scnetwork.bus.clients.fias.DownloadServiceSoap;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.DataRequest;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProvidersStadard;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.fias.domain.*;
import net.scnetwork.bus.providers.fias.enums.FiasOperation;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Обработка сервиса FIAS
 */
public class FiasCore implements IProvidersStadard{
    private DownloadServiceSoap serviceSoap;
    private Fias fias;

    /**
     * Инициализация конфигурации
     * @param config - конфигурация сервиса
     */
    public FiasCore(Fias config){
        DownloadService service = new DownloadService();
        serviceSoap = service.getDownloadServiceSoap();
        fias = config;
    }

    @Override
    public Response processingXml(@NotNull DataRequest data) {
        if (null != fias) {
            if (fias.isUse()) {
                UseEnum use = UseEnum.valueOf(fias.getService());
                switch (use) {
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
    public ResponseJs processing(@NotNull DataJs data) {
        if (null != fias){
            if (fias.isUse()){
                UseEnum use = UseEnum.valueOf(fias.getService());
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
    public Response localProcessingXml(@NotNull DataRequest data) {
        FiasOptions options = ((DataReqFias) data).getFiasOptions();
        if (null != options) {
            FiasOperation operation = options.getFiasOperation();
            if (null != operation) {
                switch (operation) {
                    case GET_URL:
                        DownloadFileInfo fileInfo = serviceSoap.getLastDownloadFileInfo();
                        if (null != fileInfo) {
                            ResponseFias response = new ResponseFias();
                            DataRespFias dataResponse = new DataRespFias();
                            dataResponse.setStatus(StatusEnum.OK);
                            dataResponse.setService(ServiceEnum.FIAS);
                            switch (options.getFormatEnum()) {
                                case DBF:
                                    dataResponse.setResponse(fileInfo.getFiasCompleteDbfUrl());
                                    break;
                                case XML:
                                    dataResponse.setResponse(fileInfo.getFiasCompleteXmlUrl());
                                    break;
                                case SEVEN_Z:
                                    dataResponse.setResponse(fileInfo.getKladr47ZUrl());
                                    break;
                                case ARJ:
                                    dataResponse.setResponse(fileInfo.getKladr4ArjUrl());
                                    break;
                                case TEXT:
                                    dataResponse.setResponse(fileInfo.getTextVersion());
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
                        ResponseFias response = new ResponseFias();
                        DataRespFias dataResponse = new DataRespFias();
                        if (!list.isEmpty()) {
                            dataResponse.setStatus(StatusEnum.OK);
                            final List<ParamFias> params = new ArrayList<>();
                            list.forEach(e -> {
                                ParamFias param = getMultiplyINfo(e, options);
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
        return new ResponseFias();
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

    private ParamFias getMultiplyINfo(DownloadFileInfo info, FiasOptions options){
        ParamFias param = new ParamFias();
        param.setId(info.getVersionId());
        switch (options.getFormatEnum()) {
            case TEXT:
                param.setUrl(info.getTextVersion());
                break;
            case ARJ:
                param.setUrl(info.getKladr4ArjUrl());
                break;
            case SEVEN_Z:
                param.setUrl(info.getKladr47ZUrl());
                break;
            case XML:
                param.setUrl(info.getFiasCompleteXmlUrl());
                break;
            case DBF:
                param.setUrl(info.getFiasCompleteDbfUrl());
                break;
            default:
                break;
        }
        return param;
    }
}
