package net.scnetwork.bus.providers;

import net.scnetwork.bus.domain.DataJs;
import net.scnetwork.bus.domain.DataRequest;
import net.scnetwork.bus.domain.Response;
import net.scnetwork.bus.domain.ResponseJs;

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
