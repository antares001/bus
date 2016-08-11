import net.scnetwork.bus.clients.fias.ArrayOfDownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadFileInfo;
import net.scnetwork.bus.clients.fias.DownloadService;
import net.scnetwork.bus.clients.fias.DownloadServiceSoap;
import org.junit.Test;

import java.util.List;

public class FiasTest {
    @Test
    public void testClientFias(){
        DownloadService service = new DownloadService();
        DownloadServiceSoap serviceSoap = service.getDownloadServiceSoap();

        ArrayOfDownloadFileInfo fileInfo = serviceSoap.getAllDownloadFileInfo();
        List<DownloadFileInfo> list = fileInfo.getDownloadFileInfo();
        list.forEach(e -> System.out.println(e.getVersionId() + " => " + e.getKladr47ZUrl()));
    }
}
