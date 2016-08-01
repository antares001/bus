package net.scnetwork.bus;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.Forex.ForexCore;
import net.scnetwork.bus.providers.Qiwi.QiwiCore;

public class Dispatcher {
    public Response soapXmlDispatcher(Data data, ServiceEnum service){
        switch (service){
            case QIWI:
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processingXml(data);
            case FOREX:
                ForexCore fix = new ForexCore();
                return fix.processingXml(data);
            default:
                break;
        }
        return null;
    }

    public ResponseJs soapJsDispatcher(DataJs data, ServiceEnum service){
        switch (service){
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
