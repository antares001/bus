package net.scnetwork.bus.providers.Artosis;

import net.scnetwork.bus.config.modules.Artosis;
import net.scnetwork.bus.domain.Data;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.IProviders;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ArtosisCore implements IProviders{
    @Autowired
    private Artosis artosis;

    @Override
    public Response processingXml(Data data) {
        if (artosis.isUse()) {
            switch (artosis.getUseEnum()){
                case LOCAL:
                    String point = artosis.getPoint();
                    break;
                case REMOTE:
                    String microservice = artosis.getUrl();
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
        if (artosis.isUse()) {
            switch (artosis.getUseEnum()){
                case LOCAL:
                    String point = artosis.getPoint();
                    break;
                case REMOTE:
                    String microservice = artosis.getUrl();
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
