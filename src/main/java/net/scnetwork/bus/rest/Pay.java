package net.scnetwork.bus.rest;

import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.utils.JsonUtils;
import net.scnetwork.bus.utils.XmlUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Обработка запросов оплаты по протоколу REST
 */
@RestController
public class Pay {
    /**
     * Формирование XML ответа на запрос оплаты
     * @param service сервис
     * @param sum сумма
     * @param currency валюта
     * @param newData новые данные (опционально)
     * @return XML ответ
     */
    @RequestMapping(value = "/rest/xml/pay/{service}", method = RequestMethod.POST)
    public Response payXml(@PathVariable(value = "service") ServiceEnum service,
                           @RequestParam(value = "sum") BigDecimal sum,
                           @RequestParam(value = "currency") int currency,
                           @RequestParam(value = "newdata", required = false) String newData){
        switch (service){
            case BPAY:
            case LEADER:
            case IDC:
            case MTS:
            case BEELINE:
            case MEGAFON:
            case FOREX:
            case QIWI:
            case YANDEX:
            default:
                break;
        }
        return XmlUtils.getError(StatusEnum.NULL);
    }

    /**
     * Формирование ответа JSON запроса на оплату
     * @param service сервис
     * @param sum сумма
     * @param currency валюта
     * @param newData новые данные (опционально)
     * @return JSON ответ
     */
    @RequestMapping(value = "/rest/js/pay/{service}", method = RequestMethod.POST)
    public ResponseJs payJs(@PathVariable(value = "service") ServiceEnum service,
                            @RequestParam(value = "sum") BigDecimal sum,
                            @RequestParam(value = "currency") int currency,
                            @RequestParam(value = "newdata", required = false) String newData){
        switch (service){
            case BPAY:
            case LEADER:
            case IDC:
            case MTS:
            case BEELINE:
            case MEGAFON:
            case FOREX:
            case QIWI:
            case YANDEX:
            default:
                break;
        }
        return JsonUtils.getError(StatusEnum.NULL);
    }
}
