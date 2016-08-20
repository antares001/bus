package net.scnetwork.bus.test;

import net.scnetwork.bus.domain.Auth;
import net.scnetwork.bus.domain.Request;
import net.scnetwork.bus.enums.ServiceEnum;
import net.scnetwork.bus.providers.bpay.domain.BPayOptions;
import net.scnetwork.bus.providers.bpay.domain.DataReqBpay;
import net.scnetwork.bus.providers.bpay.enums.BPayMethod;
import net.scnetwork.bus.providers.bpay.enums.BPayOperation;
import org.junit.Test;

public class JaxbTest {
    @Test
    public void createRequestTest(){
        Request request = new Request();
        request.setType(1);

        Auth auth = new Auth();
        auth.setLogin("login");
        auth.setPass("password");
        auth.setService(ServiceEnum.BPAY);
        request.setAuth(auth);

        DataReqBpay data = new DataReqBpay();
        BPayOptions options = new BPayOptions();
        options.setCurrency(498);
        options.setMethod(BPayMethod.BPAY);
        options.setOperation(BPayOperation.INFO);
        data.setbPayOptions(options);

        request.setData(data);

        System.out.println(request);
    }
}
