package net.scnetwork.bus.providers.yandex;

import com.yandex.money.api.YandexMoney;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.modules.Yandex;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.domain.DataRequest.DataReqYandex;
import net.scnetwork.bus.domain.providers.YandexOptions;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

public class YandexCore implements IProviders{
    private Yandex yandex = Config.getInstance().getModules().getYandex();

    private static final String CLIENT_ID = "";

    @Override
    public Response processingXml(Data data) {
        if (yandex.isUse()) {
            switch (UseEnum.valueOf(yandex.getService())){
                case LOCAL:
                    YandexMoney yandexMoney = new YandexMoney(CLIENT_ID);
                    YandexOptions options =((DataReqYandex) data).getYandexOptions();
                    switch (options.getOperation()) {
                        case ACCOUNT_INFO:
                            break;
                        case OPERATION_HISTORY:
                            break;
                        case OPERATION_DETAILS:
                            break;
                        case INCOMING_TRANSFERS:
                            break;
                        case PAYMENT:
                            break;
                        case PAYMENT_SHOP:
                            break;
                        case PAYMENT_P2P:
                            break;
                        case MONEY_SOURCE:
                            break;
                        default:
                            break;
                    }
                    break;
                case REMOTE:
                    String microservice = yandex.getUrl();
                    break;
                case NONE:
                    break;
                default:
                    return XmlUtils.getError(StatusEnum.ERROR_CONFIG);
            }
            return null;
        } else {
            return XmlUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (yandex.isUse()) {
            switch (UseEnum.valueOf(yandex.getService())){
                case LOCAL:
                    break;
                case REMOTE:
                    String microservice = yandex.getUrl();
                    break;
                case NONE:
                    break;
                default:
                    return JsonUtils.getError(StatusEnum.ERROR_CONFIG);
            }
            return null;
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
