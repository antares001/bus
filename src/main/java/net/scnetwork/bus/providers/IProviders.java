package net.scnetwork.bus.providers;

import net.scnetwork.bus.domain.*;

/**
 * Интерфейс для определения операций
 */
public interface IProviders {
    /**
     * Обработка запроса в формате xml
     * @param data входящие параметры
     * @return ответ шины
     */
    Response processingXml(DataRequest data);

    /**
     * Обработка запроса в формате json
     * @param data входящие параметры
     * @return ответ шины
     */
    ResponseJs processing(DataJs data);

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
