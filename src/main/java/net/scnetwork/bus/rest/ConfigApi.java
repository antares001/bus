package net.scnetwork.bus.rest;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.config.Modules;
import net.scnetwork.bus.enums.DaoEnums;
import net.scnetwork.bus.providers.bpay.config.BPay;
import net.scnetwork.bus.providers.fias.config.Fias;
import net.scnetwork.bus.providers.forex.config.Forex;
import net.scnetwork.bus.providers.jpos.config.Jpos;
import net.scnetwork.bus.providers.leader.config.Leader;
import net.scnetwork.bus.providers.print.config.Print;
import net.scnetwork.bus.providers.qiwi.config.Qiwi;
import net.scnetwork.bus.providers.yandex.config.Yandex;
import net.scnetwork.bus.utils.LogBus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     * Единая точка входа
     * @return точка
     */
    @RequestMapping(value = "/rest/api/get/endpoint", method = RequestMethod.GET)
    public String getEndpoint(){
        Global global = Config.getInstance();
        if (null != global) {
            return global.getEndpoint();
        } else {
            return null;
        }
    }

    /**
     * Установка endpoint
     * @param endpont единая точка входа
     * @return результат опареции (true - успешно, false - не успешно)
     */
    @RequestMapping(value = "/rest/api/set/endpoint", method = RequestMethod.GET)
    public boolean setEndpoint(@RequestParam(value = "endpoint") String endpont) {
        if (null != endpont) {
            Global global = Config.getInstance();
            if (null != global) {
                global.setEndpoint(endpont);
                Config.setInstance(global);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Тип подключения к БД
     * @return тип подключения
     */
    @RequestMapping(value = "/rest/api/get/dao", method = RequestMethod.GET)
    public String getDao(){
        Global global = Config.getInstance();
        if (null != global){
            return global.getDao().getName();
        } else {
            return null;
        }
    }

    /**
     * Запись типа подключения к БД
     * @param dao тип подключения
     * @return результат выполнения операции
     */
    @RequestMapping(value = "/rest/api/set/dao", method = RequestMethod.GET)
    public boolean setDao(@RequestParam(value = "value") String dao){
        if (null != dao){
            Global global = Config.getInstance();
            if (null != global){
                try{
                    global.setDao(DaoEnums.valueOf(dao.toUpperCase()));
                    Config.setInstance(global);
                    return true;
                } catch (Exception e){
                    LogBus.writeLog(e);
                    return false;
                }
            }
        }
        return false;
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
            Yandex yandex = modules.getYandex();
            Qiwi qiwi = modules.getQiwi();
            Leader leader = modules.getLeader();
            Jpos jpos = modules.getJpos();
            Fias fias = modules.getFias();
            Print print = modules.getPrint();
            Forex forex = modules.getForex();

            if (null != bPay && bPay.isUse())
                result.add(BPay.DESCRIPTION);

            if (null != yandex && yandex.isUse())
                result.add(Yandex.DESCRIPTION);

            if (null != qiwi && qiwi.isUse())
                result.add(Qiwi.DESCRIPTION);

            if (null != leader && leader.isUse())
                result.add(Leader.DESRIPTION);

            if (null != jpos && jpos.isUse())
                result.add(Jpos.DESCRIPTION);

            if (null != fias && fias.isUse())
                result.add(Fias.DESRIPTION);

            if (null != print && print.isUse())
                result.add(Print.DESCRIPTION);

            if (null != forex && forex.isUse())
                result.add(Forex.DESCRIPTION);
        }

        return result;
    }
}
