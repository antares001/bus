package net.scnetwork.bus.interfaces;


import net.scnetwork.bus.interfaces.domian.DataJs;
import net.scnetwork.bus.interfaces.domian.DataRequest;
import net.scnetwork.bus.interfaces.domian.Response;
import net.scnetwork.bus.interfaces.domian.ResponseJs;

/**
 * Стандартные сервисы
 */
public interface IProvidersStadard extends IProviders{
    /**
     * Обработка запроса в формате xml средствами шины
     * @param data входящие параметры
     * @return обработка
     */
    Response localProcessingXml(DataRequest data);

    /**
     * Обработка запроса в формате json средствами шины
     * @param data входящие параметры
     * @return обработка
     */
    ResponseJs localProcessingJson(DataJs data);

    /**
     * Обработка запроса в формате xml средствами микросервиса
     * @param data входящие параметры
     * @return обработка
     */
    Response remoteProcessingXml(DataRequest data);

    /**
     * Обработка запроса в формате json средствами микросервиса
     * @param data входящие параметры
     * @return обработка
     */
    ResponseJs remoteProcessingJson(DataJs data);
}
