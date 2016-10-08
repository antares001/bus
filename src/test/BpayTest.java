import net.scnetwork.bus.Bus;
import net.scnetwork.bus.domain.Auth;
import net.scnetwork.bus.enums.OperationEnum;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.enums.StatusEnum;
import net.scnetwork.bus.providers.bpay.enums.BPayOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;

/**
 * Тестирование сервиса Bpay
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bus.class)
@WebAppConfiguration
public class BpayTest {
    private RestTemplate restTemplate = new RestTemplate();

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



    /**
     * Тестирование структуры ответа
     */
    @Test
    public void ResponseTest(){
        ResponseBpay response = new ResponseBpay();
        DataRespBpay data = new DataRespBpay();

        data.setResponse("OK");
        data.setDate(new Date());
        data.setDescription("Good response");
        data.setService(ServiceEnum.BPAY);
        data.setStatus(StatusEnum.OK);
        data.setBpayResponse("response_bpay");

        response.setData(data);
        try {
            JAXBContext context = JAXBContext.newInstance(ResponseBpay.class);
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(response, sw);
            System.out.println(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
