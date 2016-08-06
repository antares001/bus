package net.scnetwork.bus;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.Bpay.BPayCore;
import net.scnetwork.bus.providers.Beeline.BeelineCore;
import net.scnetwork.bus.providers.Forex.ForexCore;
import net.scnetwork.bus.providers.Idc.IdcCore;
import net.scnetwork.bus.providers.Leader.LeaderCore;
import net.scnetwork.bus.providers.Megafon.MegafonCore;
import net.scnetwork.bus.providers.Mts.MtsCore;
import net.scnetwork.bus.providers.Qiwi.QiwiCore;
import net.scnetwork.bus.providers.Yandex.YandexCore;

public class Dispatcher {
    public Response soapXmlDispatcher(Data data, ServiceEnum service){
        switch (service){
            case ARTOSIS:
                BPayCore artosis = new BPayCore();
                return artosis.processingXml(data);
            case IDC:
                IdcCore idc = new IdcCore();
                return idc.processingXml(data);
            case MTS:
                MtsCore mts = new MtsCore();
                return mts.processingXml(data);
            case BEELINE:
                BeelineCore beeline = new BeelineCore();
                return beeline.processingXml(data);
            case MEGAFON:
                MegafonCore megafon = new MegafonCore();
                return megafon.processingXml(data);
            case LEADER:
                LeaderCore leader = new LeaderCore();
                return leader.processingXml(data);
            case QIWI:
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processingXml(data);
            case FOREX:
                ForexCore fix = new ForexCore();
                return fix.processingXml(data);
            case YANDEX:
                YandexCore yandex = new YandexCore();
                return yandex.processingXml(data);
            default:
                break;
        }
        return null;
    }

    public ResponseJs soapJsDispatcher(DataJs data, ServiceEnum service){
        switch (service){
            case ARTOSIS:
                BPayCore artosis = new BPayCore();
                return artosis.processing(data);
            case IDC:
                IdcCore idc = new IdcCore();
                return idc.processing(data);
            case MTS:
                MtsCore mts = new MtsCore();
                return mts.processing(data);
            case QIWI:
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processing(data);
            case FOREX:
                ForexCore fix = new ForexCore();
                return fix.processing(data);
            default:
                break;
        }
        return null;
    }

    public Response restXmlDispatcher(String request){
        return null;
    }

    public ResponseJs restJsDispatcher(String request){
        return null;
    }
}
