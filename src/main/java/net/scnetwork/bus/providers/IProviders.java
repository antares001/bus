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
}
