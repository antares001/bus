package net.scnetwork.bus.interfaces;

import net.scnetwork.bus.interfaces.domian.DataJs;
import net.scnetwork.bus.interfaces.domian.DataRequest;
import net.scnetwork.bus.interfaces.domian.Response;
import net.scnetwork.bus.interfaces.domian.ResponseJs;

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
