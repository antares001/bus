import net.scnetwork.bus.domain.Auth;
import net.scnetwork.bus.enums.OperationEnum;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.qiwi.domain.DataReqQiwi;
import net.scnetwork.bus.providers.qiwi.domain.QiwiOptions;
import net.scnetwork.bus.providers.qiwi.domain.RequestQiwi;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;

public class QiwiTest {
    @Test
    public void RequestTest(){
        RequestQiwi request = new RequestQiwi();

        Auth auth = new Auth();
        auth.setService(ServiceEnum.QIWI);
        auth.setLogin("login");
        auth.setPass("password");
        request.setAuth(auth);

        DataReqQiwi data = new DataReqQiwi();

        data.setAccount("+79261312477");
        data.setDate(new Date());
        data.setOperation(OperationEnum.CHECK);

        QiwiOptions options = new QiwiOptions();
        options.setOperation("test");
        data.setOptions(options);

        request.setData(data);

        try {
            JAXBContext context = JAXBContext.newInstance(RequestQiwi.class);
            Marshaller marshaller = context.createMarshaller();

            StringWriter sw = new StringWriter();
            marshaller.marshal(request, sw);
            System.out.println(sw.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
