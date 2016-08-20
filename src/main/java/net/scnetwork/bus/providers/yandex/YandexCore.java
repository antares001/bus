package net.scnetwork.bus.providers.yandex;

import com.yandex.money.api.YandexMoney;
import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.providers.yandex.domain.DataReqYandex;
import net.scnetwork.bus.providers.yandex.domain.YandexOptions;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.providers.yandex.config.Yandex;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.LogBus;
import net.scnetwork.bus.utils.XmlUtils;

/**
 * Обработка сервиса Yandex
 */
public class YandexCore implements IProviders{
    private Yandex yandex;
    private static final String CLIENT_ID = "";

    /**
     * Инициализация конфигурации сервиса
     */
    public YandexCore(){
        try{
            yandex = Config.getInstance().getModules().getYandex();
        } catch (NullPointerException e){
            LogBus.writeLog(e);
        }
    }

    @Override
    public Response processingXml(DataRequest data) {
        if (null != yandex) {
            if (yandex.isUse()) {
                switch (UseEnum.valueOf(yandex.getService())) {
                    case LOCAL:
                        return localProcessingXml(data);
                    case REMOTE:
                        return remoteProcessingXml(data);
                    case NONE:
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
        if (null != yandex) {
            if (yandex.isUse()) {
                switch (UseEnum.valueOf(yandex.getService())) {
                    case LOCAL:
                        return localProcessingJson(data);
                    case REMOTE:
                        return remoteProcessingJson(data);
                    case NONE:
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
        YandexMoney yandexMoney = new YandexMoney(CLIENT_ID);
        YandexOptions options = ((DataReqYandex) data).getYandexOptions();
        switch (options.getOperation()) {
            case ACCOUNT_INFO:
            case OPERATION_HISTORY:
            case OPERATION_DETAILS:
            case INCOMING_TRANSFERS:
            case PAYMENT:
            case PAYMENT_SHOP:
            case PAYMENT_P2P:
            case MONEY_SOURCE:
            default:
                break;
        }
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
