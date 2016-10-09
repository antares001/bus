import com.atlassian.jira.rest.client.api.domain.*;
import com.google.common.collect.Iterables;
import net.scnetwork.bus.clients.tracking.jira.JiraConfig;
import net.scnetwork.bus.clients.tracking.jira.JiraRestImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Тест интеграции с Jira
 */
public class JiraRestTest {
    private JiraRestImpl jiraRest;

    private static final String URL = "http://192.168.0.20:8080";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final String KEY = "BUS-1";

    private static final String SIZE_NULL = "Size is 0";

    @Before
    public void startTestJira(){
        JiraConfig config = new JiraConfig();
        config.setUse(true);
        config.setUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);

        jiraRest = new JiraRestImpl(config);
    }

    @Test
    public void getInfoServerTest(){
        ServerInfo info = jiraRest.infoServer();
        System.out.println(info.toString());
    }

    @Test
    public void getIssueInfoTest(){
        Issue issue = jiraRest.getIssue(KEY);
        System.out.println(issue.toString());
    }

    @Test
    public void getCommentsTest(){
        Iterable<Comment> comments = jiraRest.getComment(KEY);
        if (Iterables.size(comments) != 0){
            comments.forEach(e -> System.out.println(e.toString()));
        } else {
            System.out.println(SIZE_NULL);
        }
    }

    @Test
    public void getAttachmentsTest(){
        Iterable<Attachment> attachments = jiraRest.getAttachment(KEY);
        if (Iterables.size(attachments) != 0){
            attachments.forEach(e -> System.out.println(e.toString()));
        } else {
            System.out.println(SIZE_NULL);
        }
    }

    @Test
    public void getTransitions(){
        Iterable<Transition> transitions = jiraRest.getTransitions(KEY);
        if (Iterables.size(transitions) != 0){
            transitions.forEach(e -> System.out.println(e.toString()));
        } else {
            System.out.println(SIZE_NULL);
        }
    }
}
