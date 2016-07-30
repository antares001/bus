package net.scnetwork.bus;

import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;

public class Dispatcher {
    public Response soapXmlDispatcher(Data data){
        return null;
    }

    public ResponseJs soapJsDispatcher(DataJs data){
        return null;
    }

    public Response restXmlDispatcher(String request){
        return null;
    }

    public ResponseJs restJsDispatcher(String request){
        return null;
    }
}
