import net.scnetwork.bus.domain.Auth;
import net.scnetwork.bus.enums.OperationEnum;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.bpay.domain.BPayOptions;
import net.scnetwork.bus.providers.bpay.domain.DataReqBpay;
import net.scnetwork.bus.providers.bpay.domain.RequestBpay;
import net.scnetwork.bus.providers.bpay.enums.BPayOperation;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;

/**
 * Тестирование сервиса Bpay
 */
public class BpayTest {
    /**
     * Тестирование структуры входящего запроса
     */
    @Test
    public void RequestTest(){
        RequestBpay request = new RequestBpay();

        Auth auth = new Auth();
        auth.setService(ServiceEnum.BPAY);
        auth.setLogin("login");
        auth.setPass("password");
        request.setAuth(auth);

        DataReqBpay data = new DataReqBpay();

        data.setAccount("+37369324680");
        data.setDate(new Date());
        data.setOperation(OperationEnum.CHECK);

        BPayOptions options = new BPayOptions();
        options.setOperation(BPayOperation.INFO);
        options.setCurrency(498);
        data.setbPayOptions(options);

        request.setData(data);

        try {
            JAXBContext context = JAXBContext.newInstance(RequestBpay.class);
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(request, sw);
            System.out.println(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
