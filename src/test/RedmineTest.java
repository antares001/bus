import com.taskadapter.redmineapi.*;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Project;
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
        config.setUsername("bus");
        config.setPassword("q1w2e3r45t");

        System.out.println(config.getUri());
    }

    @Test
    public void testProjects(){
        RedmineManager manager = RedmineManagerFactory.createWithUserAuth(config.getUri(), config.getUsername(), config.getPassword());
        ProjectManager projectManager = manager.getProjectManager();
        try {
            List<Project> projects = projectManager.getProjects();
            projects.forEach(e -> System.out.println(e.toString()));
        } catch (RedmineException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIssues(){
        RedmineManager manager = RedmineManagerFactory.createWithUserAuth(config.getUri(), config.getUsername(), config.getPassword());
        IssueManager issueManager = manager.getIssueManager();
        try {
            List<Issue> issues = issueManager.getIssues("2", null);
            issues.forEach(e -> System.out.println(e.toString()));
        } catch (RedmineException e) {
            e.printStackTrace();
        }
    }
}
