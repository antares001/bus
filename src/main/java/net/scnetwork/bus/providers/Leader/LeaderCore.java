package net.scnetwork.bus.providers.Leader;

import net.scnetwork.bus.config.modules.Leader;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class LeaderCore implements IProviders{
    @Autowired
    private Leader leader;

    @Override
    public Response processingXml(Data data) {
        if (leader.isUse()) {
            switch (leader.getUseEnum()){
                case LOCAL:
                    String point = leader.getPoint();
                    break;
                case REMOTE:
                    String microserviceUrl = leader.getUrl();
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
        if (leader.isUse()) {
            switch (leader.getUseEnum()){
                case LOCAL:
                    String point = leader.getPoint();
                    break;
                case REMOTE:
                    String microserviceUrl = leader.getUrl();
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
}
