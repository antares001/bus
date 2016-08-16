package net.scnetwork.bus.rest;

import net.scnetwork.bus.Dispatcher;
import net.scnetwork.bus.domain.*;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.beeline.domain.DataRespBeeline;
import net.scnetwork.bus.providers.bpay.BPayCore;
import net.scnetwork.bus.providers.beeline.BeelineCore;
import net.scnetwork.bus.providers.bpay.domain.DataRespBpay;
import net.scnetwork.bus.providers.forex.ForexCore;
import net.scnetwork.bus.providers.forex.domain.DataRespForex;
import net.scnetwork.bus.providers.idc.IdcCore;
import net.scnetwork.bus.providers.idc.domain.DataRespIdc;
import net.scnetwork.bus.providers.leader.LeaderCore;
import net.scnetwork.bus.providers.leader.domain.DataRespLeader;
import net.scnetwork.bus.providers.megafon.MegafonCore;
import net.scnetwork.bus.providers.megafon.domain.DataRespMegafon;
import net.scnetwork.bus.providers.mts.MtsCore;
import net.scnetwork.bus.providers.mts.domain.DataRespMts;
import net.scnetwork.bus.providers.qiwi.QiwiCore;
import net.scnetwork.bus.providers.qiwi.domain.DataRespQiwi;
import net.scnetwork.bus.providers.yandex.YandexCore;
import net.scnetwork.bus.providers.yandex.domain.DataRespYandex;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Обработка запросов на получение состояния по протоколу REST
 */
@RestController
public class GetInfo {
    private Dispatcher dispatcher = new Dispatcher();

    @RequestMapping(value = "/rest/get/echo", method = RequestMethod.GET)
    public String echoGet(){
        return "test running";
    }

    /**
     * Формирование XML по запросу состояния
     * @param service сервис
     * @param account лицевой счет
     * @return XML ответ
     */
    @RequestMapping("/rest/getXml/{service}/{account}")
    public Response restGetXml(@PathVariable(value = "service") ServiceEnum service,
                               @PathVariable(value = "account") String account){
        Data data;
        switch (service){
            case BPAY:
                data = new DataRespBpay();
                BPayCore artosis = new BPayCore();
                return artosis.processingXml(data);
            case IDC:
                data = new DataRespIdc();
                IdcCore idc = new IdcCore();
                return idc.processingXml(data);
            case LEADER:
                data = new DataRespLeader();
                LeaderCore leader = new LeaderCore();
                return leader.processingXml(data);
            case MTS:
                data = new DataRespMts();
                MtsCore mts = new MtsCore();
                return mts.processingXml(data);
            case BEELINE:
                data = new DataRespBeeline();
                BeelineCore beeline = new BeelineCore();
                return beeline.processingXml(data);
            case MEGAFON:
                data = new DataRespMegafon();
                MegafonCore megafon = new MegafonCore();
                return megafon.processingXml(data);
            case FOREX:
                data = new DataRespForex();
                ForexCore fix = new ForexCore();
                return fix.processingXml(data);
            case QIWI:
                data = new DataRespQiwi();
                QiwiCore qiwi = new QiwiCore();
                return qiwi.processingXml(data);
            case YANDEX:
                data = new DataRespYandex();
                YandexCore yandex = new YandexCore();
                return yandex.processingXml(data);
            default:
                break;
        }
        return dispatcher.restXmlDispatcher("");
    }

    /**
     * Формирование JSON на запрос состояния
     * @param service сервис
     * @param account лицевой счет
     * @return JSON ответ
     */
    @RequestMapping(value = "/rest/getJson/{service}", method = RequestMethod.GET)
    public ResponseJs restGetJson(@PathVariable(value = "service") ServiceEnum service,
                                  @RequestParam(value = "account") String account){
        DataJs data = new DataJs();
        data.setAccount(account);
        switch (service){
            case BPAY:
                BPayCore artosis = new BPayCore();
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

    /**
     * Подключение enum к REST
     * @param dataBinder переменная связывания
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(ServiceEnum.class, new ServiceConverter());
    }
}
