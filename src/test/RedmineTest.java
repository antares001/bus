import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;
import net.scnetwork.bus.clients.tracking.redmine.RedmineConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RedmineTest {
    private RedmineConfig config;

    @Before
    public void init(){
        config = new RedmineConfig();
        config.setUri("http://192.168.0.20:3000");
        config.setUse(true);
        config.setTokenTracker("WxO0LZ44ju0tzdrF6KIM");
        config.setTokenVcs("A0sAyBqgk5yAeMapAdCL");

        System.out.println(config.getUri());
    }

    @Test
    public void testConnection(){
        RedmineManager manager = RedmineManagerFactory.createWithApiKey(config.getUri(), config.getTokenTracker());
        IssueManager issueManager = manager.getIssueManager();
        try {
            List<Issue> issues = issueManager.getIssues("BUS", 1);
            issues.forEach(e -> System.out.println(e.toString()));
        } catch (RedmineException e) {
            e.printStackTrace();
        }
    }
}
