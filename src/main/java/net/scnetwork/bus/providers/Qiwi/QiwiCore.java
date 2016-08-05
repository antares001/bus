package net.scnetwork.bus.providers.Qiwi;

import net.scnetwork.bus.config.modules.Qiwi;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class QiwiCore implements IProviders{
    @Autowired
    private Qiwi qiwi;

    @Override
    public Response processingXml(Data data) {
        if (qiwi.isUse()) {
            switch (qiwi.getUseEnum()){
                case LOCAL:
                    break;
                case REMOTE:
                    break;
                case NONE:
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
        if (qiwi.isUse()) {
            switch (qiwi.getUseEnum()){
                case LOCAL:
                    break;
                case REMOTE:
                    break;
                case NONE:
                    break;
                default:
                    break;
            }
            return null;
        } else {
            return JsonUtils.getError(StatusEnum.NOT_SUPPORT);
        }
    }
}
