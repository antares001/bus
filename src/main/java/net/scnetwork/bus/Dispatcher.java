package net.scnetwork.bus;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.bpay.BPayCore;
import net.scnetwork.bus.providers.beeline.BeelineCore;
import net.scnetwork.bus.providers.fias.FiasCore;
import net.scnetwork.bus.providers.forex.ForexCore;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.providers.leader.LeaderCore;
import net.scnetwork.bus.providers.megafon.MegafonCore;
import net.scnetwork.bus.providers.mts.MtsCore;
import net.scnetwork.bus.providers.qiwi.QiwiCore;
import net.scnetwork.bus.providers.yandex.YandexCore;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

/**
 * Класс-маршрутизатор вызовов
 */
public class Dispatcher {

    /**
     * Формирование soap ответа в виде xml
     * @param data входящие данные
     * @param service тип сервиса
     * @return ответ
     */
    public Response soapXmlDispatcher(Data data, ServiceEnum service){
        IProviders providers;
        switch (service){
            case BPAY:
                providers = new BPayCore();
                break;
            case MTS:
                providers = new MtsCore();
                break;
            case BEELINE:
                providers = new BeelineCore();
                break;
            case MEGAFON:
                providers = new MegafonCore();
                break;
            case LEADER:
                providers = new LeaderCore();
                break;
            case QIWI:
                providers = new QiwiCore();
                break;
            case FOREX:
                providers = new ForexCore();
                break;
            case YANDEX:
                providers = new YandexCore();
                break;
            case FIAS:
                providers = new FiasCore();
                break;
            default:
                return XmlUtils.getError(StatusEnum.FORMAT_ERROR);
        }
        return providers.processingXml(data);
    }

    /**
     * Формирование soap ответа в формате json
     * @param data входящие данные
     * @param service тип сервиса
     * @return ответ
     */
    public ResponseJs soapJsDispatcher(DataJs data, ServiceEnum service){
        IProviders providers;
        switch (service){
            case BPAY:
                providers = new BPayCore();
                break;
            case MTS:
                providers = new MtsCore();
                break;
            case QIWI:
                providers = new QiwiCore();
                break;
            case LEADER:
                providers = new LeaderCore();
                break;
            case FOREX:
                providers = new ForexCore();
                break;
            case BEELINE:
                providers = new BeelineCore();
                break;
            case MEGAFON:
                providers = new MegafonCore();
                break;
            case YANDEX:
                providers = new YandexCore();
                break;
            case FIAS:
                providers = new FiasCore();
                break;
            default:
                return JsonUtils.getError(StatusEnum.FORMAT_ERROR);
        }
        return providers.processing(data);
    }

    /**
     * Формирование rest ответа в виде xml
     * @param request входящие данные
     * @return ответ
     */
    public Response restXmlDispatcher(String request){
        return new Response();
    }

    /**
     * Формирование rest ответа в формате json
     * @param request входящие данные
     * @return ответ
     */
    public ResponseJs restJsDispatcher(String request){
        ResponseJs response = new ResponseJs();
        DataJs data = new DataJs();
        data.setOperation(request);
        response.setData(data);
        return response;
    }
}
