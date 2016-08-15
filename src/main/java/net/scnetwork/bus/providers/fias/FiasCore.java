package net.scnetwork.bus.providers.fias;

import net.scnetwork.bus.clients.fias.DownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadService;
import net.scnetwork.bus.clients.fias.DownloadServiceSoap;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.XmlUtils;

/**
 * Обработка сервиса FIAS
 */
public class FiasCore implements IProviders{
    private DownloadServiceSoap serviceSoap;

    public FiasCore(){
        DownloadService service = new DownloadService();
        serviceSoap = service.getDownloadServiceSoap();
    }

    @Override
    public Response processingXml(Data data) {
        FiasOptions options = data.getFiasOptions();
        if (null != options){
            FiasOperation operation = options.getFiasOperation();
            if (null != operation){
                switch (operation){
                    case GET_URL:
                        DownloadFileInfo fileInfo = serviceSoap.getLastDownloadFileInfo();
                        if (null != fileInfo){
                            Response response = new Response();
                            Data dataResponse = new Data();
                            dataResponse.setStatus(StatusEnum.OK);
                            dataResponse.setService(ServiceEnum.FIAS);
                            switch (options.getFormatEnum()){
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
                    default:
                        break;
                }
            }
        }
        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        return null;
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
