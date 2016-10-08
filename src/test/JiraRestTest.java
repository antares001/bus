import com.atlassian.jira.rest.client.api.domain.ServerInfo;
import net.scnetwork.bus.clients.tracking.jira.JiraConfig;
import net.scnetwork.bus.clients.tracking.jira.JiraRestImpl;
import org.junit.Test;

public class JiraRestTest {
    @Test
    public void getInfoServerTest(){
        JiraConfig config = new JiraConfig();
        config.setUse(true);
        config.setUrl("http://192.168.0.20:8080");
        config.setUsername("user");
        config.setPassword("password");

        JiraRestImpl jiraRest = new JiraRestImpl(config);
        ServerInfo info = jiraRest.infoServer();
        System.out.println(info.toString());
    }
}
