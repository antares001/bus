package net.scnetwork.bus.rest.api;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.forex.config.Forex;
import net.scnetwork.bus.providers.jpos.config.JposConfig;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.providers.print.config.Print;
import net.scnetwork.bus.providers.qiwi.config.Qiwi;
import net.scnetwork.bus.providers.yandex.config.Yandex;
import net.scnetwork.bus.utils.LogBus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * REST API BUS
 */
@RestController
public class ConfigApi {
    /**
     * Получение всех конфигурационной информации
     *
     * @return конфигурация
     */
    @RequestMapping(value = "/rest/api/all", method = RequestMethod.GET)
    public Global getAllConfig() {
        return Config.getInstance();
    }

    /**
     * Список модулей
     * @return список
     */
    @RequestMapping(value = "/rest/api/modules", method = RequestMethod.GET)
    public List<String> getAllModules(){
        List<String> result = new LinkedList<>();

        Modules modules = Config.getModules();
        if (null != modules) {
            BPay bPay = modules.getBpay();
            if (null != bPay) {
                if (bPay.isUse())
                    result.add(BPay.DESCRIPTION);
            }

            Yandex yandex = modules.getYandex();
            if (null != yandex){
                if (yandex.isUse())
                    result.add(Yandex.DESCRIPTION);
            }

            Qiwi qiwi = modules.getQiwi();
            if (null != qiwi){
                if (qiwi.isUse())
                    result.add(Qiwi.DESCRIPTION);
            }

            Leader leader = modules.getLeader();
            if (null != leader){
                if (leader.isUse())
                    result.add(Leader.DESRIPTION);
            }

            JposConfig jpos = modules.getJpos();
            if (null != jpos){
                if (jpos.isUse())
                    result.add(JposConfig.DESCRIPTION);
            }

            Fias fias = modules.getFias();
            if (null != fias){
                if (fias.isUse())
                    result.add(Fias.DESRIPTION);
            }

            Print print = modules.getPrint();
            if (null != print){
                if (print.isUse())
                    result.add("");
            }

            Forex forex = modules.getForex();
            if (null != forex){
                if (forex.isUse())
                    result.add(Forex.DESCRIPTION);
            }
        }

        return result;
    }

    /**
     * Установка endpoint
     * @param endpont единая точка входа
     * @return результат опареции (true - успешно, false - не успешно)
     */
    @RequestMapping(value = "/rest/api/set/endpoint", method = RequestMethod.GET)
    public boolean setEndpoint(String endpont) {
        if (null != endpont) {
            Global global = Config.getInstance();
            if (null != global) {
                global.setEndpoint(endpont);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
