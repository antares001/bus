package net.scnetwork.bus.providers.Yandex;

import com.yandex.money.api.YandexMoney;
import com.yandex.money.api.net.MethodRequest;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.operation.YandexOperation;
import net.scnetwork.bus.providers.IProviders;

import java.security.Permission;
import java.util.Collection;
import java.util.LinkedList;

public class YandexCore implements IProviders{
    private static final String CLIENT_ID = "";

    @Override
    public Response processingXml(Data data) {
        YandexMoney yandexMoney = new YandexMoney(CLIENT_ID);

        YandexOperation operation = data.getYandexOperation();
        switch (operation){
            default:
                break;
        }

        return null;
    }

    @Override
    public ResponseJs processing(DataJs data) {
        return null;
    }
}
