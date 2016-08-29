package net.scnetwork.bus.rest.api;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.bpay.domain.BpayConfigXml;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Настройки модулей
 */
@RestController
public class ModulesApi {
    /**
     * Модуль bpay
     * @return настройки модуля
     */
    @RequestMapping(value = "/rest/api/modules/get/bpay")
    public BpayConfigXml getBpay(){
        BpayConfigXml result = new BpayConfigXml();

        Global global = Config.getInstance();
        if (null != global){
            BPay bPay = global.getModules().getBpay();
            result.setUse(bPay.isUse());
            result.setService(bPay.getService());
            result.setUrl(bPay.getUrl());
        }

        return result;
    }

    /**
     * Запись модуля bpay
     * @param use признак использования
     * @param service тип сервиса
     * @param url адрес микросервиса
     * @return результат выполнения операции
     */
    @RequestMapping(value = "/rest/api/modules/set/bpay")
    public boolean setBpay(@RequestParam(value = "use") Boolean use,
                           @RequestParam(value = "service") String service,
                           @RequestParam(value = "url") String url){
        Modules modules = Config.getModules();
        if (null != modules) {
            BPay bPay = modules.getBpay();
            if (null != use){
                bPay.setUse(use);
            }

            if (null != service){
                bPay.setService(service);
            }

            if (null != url){
                bPay.setUrl(url);
            }

            modules.setBpay(bPay);
            Config.setModules(modules);
            return true;
        }
        return false;
    }
}
