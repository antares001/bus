package net.scnetwork.bus.rest;

import net.scnetwork.bus.Dispatcher;
import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.DataJsResponse;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.beeline.BeelineCore;
import net.scnetwork.bus.providers.bpay.BPayCore;
import net.scnetwork.bus.providers.forex.ForexCore;
import net.scnetwork.bus.providers.leader.LeaderCore;
import net.scnetwork.bus.providers.megafon.MegafonCore;
import net.scnetwork.bus.providers.mts.MtsCore;
import net.scnetwork.bus.providers.qiwi.QiwiCore;
import net.scnetwork.bus.providers.yandex.YandexCore;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Обработка запросов на получение состояния по протоколу REST
 */
@RestController
public class GetInfo {
    private static final String ECHO = "test running";
    private Dispatcher dispatcher = new Dispatcher();

    /**
     * Тест сервиса
     * @return ответ
     */
    @RequestMapping(value = "/rest/get/echo", method = RequestMethod.GET)
    public String echoGet(){
        return ECHO;
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
        switch (service){
            case BPAY:
            case LEADER:
            case MTS:
            case BEELINE:
            case MEGAFON:
            case FOREX:
            case QIWI:
            case YANDEX:
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
        DataJs data = new DataJsResponse();
        data.setAccount(account);
        switch (service){
            case BPAY:
                BPayCore artosis = new BPayCore();
                return artosis.processing(data);
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
