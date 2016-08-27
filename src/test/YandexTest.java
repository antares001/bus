import net.scnetwork.bus.domain.Auth;
import net.scnetwork.bus.enums.OperationEnum;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.yandex.domain.DataReqYandex;
import net.scnetwork.bus.providers.yandex.domain.RequestYandex;
import net.scnetwork.bus.providers.yandex.domain.YandexOptions;
import net.scnetwork.bus.providers.yandex.enums.YandexOperation;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;

/**
 * Тестирование сервиса Yandex
 */
public class YandexTest {
    /**
     * Тестирование структуры входящего запроса
     */
    @Test
    public void RequestTest(){
        RequestYandex request = new RequestYandex();

        Auth auth = new Auth();
        auth.setService(ServiceEnum.YANDEX);
        auth.setLogin("login");
        auth.setPass("password");
        request.setAuth(auth);

        DataReqYandex data = new DataReqYandex();

        data.setAccount("antares001");
        data.setDate(new Date());
        data.setOperation(OperationEnum.CHECK);

        YandexOptions options = new YandexOptions();
        options.setOperation(YandexOperation.OPERATION_DETAILS);
        data.setYandexOptions(options);

        request.setData(data);

        try {
            JAXBContext context = JAXBContext.newInstance(RequestYandex.class);
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(request, sw);
            System.out.println(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
