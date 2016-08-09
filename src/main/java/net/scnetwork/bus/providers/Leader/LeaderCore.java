package net.scnetwork.bus.providers.Leader;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.modules.Leader;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.enums.UseEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;

public class LeaderCore implements IProviders{
    private Leader leader = Config.getInstance().getModules().getLeader();

    @Override
    public Response processingXml(Data data) {
        if (leader.isUse()) {
            switch (UseEnum.valueOf(leader.getService())){
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
            switch (UseEnum.valueOf(leader.getService())){
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

    @Override
    public Response localProcessingXml(Data data) {
        return null;
    }

    @Override
    public ResponseJs localProcessingJson(DataJs data) {
        return null;
    }

    @Override
    public Response remoteProcessingXml(Data data) {
        return null;
    }

    @Override
    public ResponseJs remoteProcessingJson(DataJs data) {
        return null;
    }
}
