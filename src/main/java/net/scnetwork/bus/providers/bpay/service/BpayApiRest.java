package net.scnetwork.bus.providers.bpay.service;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.rest.RestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * REST API для настройки сервиса bpay
 */
public class BpayApiRest implements RestApi{
    @RequestMapping(value = "/rest/api/modules/bpay/get/info")
    @Override
    public String getConfig() {
        Modules modules = Config.getModules();
        if (null != modules){
            BPay bPay = modules.getBpay();
            if (null != bPay){
                return bPay.toString();
            }
        }
        return null;
    }

    @RequestMapping(value = "/rest/api/modules/bpay/set/info")
    @Override
    public boolean setConfig(@RequestParam(value = "use") Boolean use,
                             @RequestParam(value = "service") String service,
                             @RequestParam(value = "url") String url) {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/bpay/get/use")
    @Override
    public boolean getUse() {
        return false;
    }

    @RequestMapping(value = "/rest/api/modules/bpay/set/use")
    @Override
    public boolean setUse(@RequestParam(value = "use") boolean use) {
        return false;
    }
}
