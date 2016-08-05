package net.scnetwork.bus.providers.Yandex;

import com.yandex.money.api.YandexMoney;
import com.yandex.money.api.net.MethodRequest;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.operation.YandexOperation;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Permission;
import java.util.Collection;
import java.util.LinkedList;

public class YandexCore implements IProviders{
    @Autowired
    private Modules modules;

    private static final String CLIENT_ID = "";

    @Override
    public Response processingXml(Data data) {
        if (modules.isYandex()) {
            YandexMoney yandexMoney = new YandexMoney(CLIENT_ID);

            YandexOperation operation = data.getYandexOperation();
            switch (operation) {
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

            return null;
        } else {
            return XmlUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }

    @Override
    public ResponseJs processing(DataJs data) {
        if (modules.isYandex()) {
            return null;
        } else {
            return JsonUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }
}
