import net.scnetwork.bus.Bus;
import net.scnetwork.bus.clients.fias.ArrayOfDownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadService;
import net.scnetwork.bus.clients.fias.DownloadServiceSoap;
import net.scnetwork.bus.domain.Auth;
import net.scnetwork.bus.enums.OperationEnum;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.fias.domain.DataReqFias;
import net.scnetwork.bus.providers.fias.domain.FiasOptions;
import net.scnetwork.bus.providers.fias.domain.RequestFias;
import net.scnetwork.bus.providers.fias.enums.FiasOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

/**
 * Тестирование модуля ФИАС
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bus.class)
@WebAppConfiguration
public class FiasTest {
    /**
     * Тестирование структуры входящего запроса
     */
    @Test
    public void RequestTest(){
        RequestFias request = new RequestFias();

        Auth auth = new Auth();
        auth.setService(ServiceEnum.BPAY);
        auth.setLogin("login");
        auth.setPass("password");
        request.setAuth(auth);

        DataReqFias data = new DataReqFias();

        data.setAccount("me");
        data.setDate(new Date());
        data.setOperation(OperationEnum.CHECK);

        FiasOptions options = new FiasOptions();
        options.setFiasOperation(FiasOperation.GET_URL);
        data.setFiasOptions(options);

        request.setData(data);

        try {
            JAXBContext context = JAXBContext.newInstance(RequestFias.class);
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(request, sw);
            System.out.println(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Тестирование получения от стороннего сервиса информации
     */
    @Test
    public void testClientFias(){
        DownloadService service = new DownloadService();
        DownloadServiceSoap serviceSoap = service.getDownloadServiceSoap();

        ArrayOfDownloadFileInfo fileInfo = serviceSoap.getAllDownloadFileInfo();
        List<DownloadFileInfo> list = fileInfo.getDownloadFileInfo();
        list.forEach(e -> System.out.println(e.getVersionId() + " => " + e.getKladr47ZUrl()));
    }
}
