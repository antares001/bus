package net.scnetwork.bus.providers.Bpay;

import net.scnetwork.bus.config.modules.BPay;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.operation.BPayOperation;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BPayCore implements IProviders{
    @Autowired
    private BPay BPay;

    @Override
    public Response processingXml(Data data) {
        if (BPay.isUse()) {
            switch (BPay.getUseEnum()){
                case LOCAL:
                    String point = BPay.getPoint();
                    BPayOperation operation = data.getBPayOperation();
                    switch (operation){
                        case BILL:
                            break;
                        case CALLBACK:
                            break;
                        case PAY:
                            break;
                        case INFO:
                            break;
                        default:
                            break;
                    }
                    break;
                case REMOTE:
                    String microservice = BPay.getUrl();
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
        if (BPay.isUse()) {
            switch (BPay.getUseEnum()){
                case LOCAL:
                    String point = BPay.getPoint();
                    break;
                case REMOTE:
                    String microservice = BPay.getUrl();
                    break;
                case NONE:
                    break;
                default:
                    JsonUtils.getError(StatusEnum.ERROR_CONFIG);
            }
            return null;
        } else {
            return JsonUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }
}
