package net.scnetwork.bus.rest;

import net.scnetwork.bus.Dispatcher;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.Artosis.ArtosisCore;
import net.scnetwork.bus.providers.Beeline.BeelineCore;
import net.scnetwork.bus.providers.Forex.ForexCore;
import net.scnetwork.bus.providers.Idc.IdcCore;
import net.scnetwork.bus.providers.Leader.LeaderCore;
import net.scnetwork.bus.providers.Megafon.MegafonCore;
import net.scnetwork.bus.providers.Mts.MtsCore;
import net.scnetwork.bus.providers.Qiwi.QiwiCore;
import net.scnetwork.bus.providers.Yandex.YandexCore;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@RestController
public class GetInfo {
    private Dispatcher dispatcher = new Dispatcher();

    @RequestMapping(value = "/rest/get/echo", method = RequestMethod.GET)
    public String echoGet(){
        return "test running";
    }

    @RequestMapping("/rest/getXml/{service}")
    public Response restGetXml(@PathVariable(value = "service") ServiceEnum service,
                               @RequestParam(value = "account") String account){
        Data data = new Data();
        data.setAccount(account);
        data.setService(service);
        switch (service){
            case ARTOSIS:
                ArtosisCore artosis = new ArtosisCore();
                return artosis.processingXml(data);
            case IDC:
                IdcCore idc = new IdcCore();
                return idc.processingXml(data);
            case LEADER:
                LeaderCore leader = new LeaderCore();
                return leader.processingXml(data);
            case MTS:
                MtsCore mts = new MtsCore();
                return mts.processingXml(data);
            case BEELINE:
                BeelineCore beeline = new BeelineCore();
                return beeline.processingXml(data);
            case MEGAFON:
                MegafonCore megafon = new MegafonCore();
                return megafon.processingXml(data);
            case FOREX:
                ForexCore fix = new ForexCore();
                return fix.processingXml(data);
            case QIWI:
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processingXml(data);
            case YANDEX:
                YandexCore yandex = new YandexCore();
                return yandex.processingXml(data);
            default:
                break;
        }
        return dispatcher.restXmlDispatcher("");
    }

    @RequestMapping(value = "/rest/getJson/{service}", method = RequestMethod.GET)
    public ResponseJs restGetJson(@PathVariable(value = "service") ServiceEnum service,
                                  @RequestParam(value = "account") String account){
        DataJs data = new DataJs();
        data.setAccount(account);
        switch (service){
            case ARTOSIS:
                ArtosisCore artosis = new ArtosisCore();
                return artosis.processing(data);
            case IDC:
                IdcCore idc = new IdcCore();
                return idc.processing(data);
            case LEADER:
                LeaderCore leader = new LeaderCore();
                return leader.processing(data);
            case MTS:
                MtsCore mts = new MtsCore();
                return mts.processing(data);
            case BEELINE:
                BeelineCore beeline = new BeelineCore();
                return beeline.processing(data);
            case MEGAFON:
                MegafonCore megafon = new MegafonCore();
                return megafon.processing(data);
            case QIWI:
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processing(data);
            case FOREX:
                ForexCore fix = new ForexCore();
                return fix.processing(data);
            case YANDEX:
                YandexCore yandex = new YandexCore();
                return yandex.processing(data);
            default:
                break;
        }
        return dispatcher.restJsDispatcher("");
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(ServiceEnum.class, new ServiceConverter());
    }
}
