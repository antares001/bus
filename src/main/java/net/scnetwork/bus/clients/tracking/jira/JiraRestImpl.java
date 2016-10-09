package net.scnetwork.bus.clients.tracking.jira;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.*;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import net.scnetwork.bus.clients.tracking.ITracking;
import net.scnetwork.bus.utils.LogBus;

import java.net.URI;

/**
 * Реализация rest клиента jira
 */
public class JiraRestImpl implements ITracking{
    private JiraRestClient restClient;

    /**
     * Конструктор
     * @param config конфигурация
     */
    public JiraRestImpl(JiraConfig config){
        AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
        restClient = factory.createWithBasicHttpAuthentication(URI.create(config.getUrl()), config.getUsername(), config.getPassword());
    }

    /**
     * Получение информации о сервере
     * @return информация
     */
    public ServerInfo infoServer(){
        return restClient.getMetadataClient().getServerInfo().claim();
    }

    /**
     * Получение данных по задаче
     * @param key ключ или id
     * @return данные
     */
    public Issue getIssue(String key){
        IssueRestClient issueRestClient = restClient.getIssueClient();
        if (null != issueRestClient){
            return issueRestClient.getIssue(key).claim();
        } else {
            return null;
        }
    }

    /**
     * Получение списка комментариев
     * @param key ключ или id задачи
     * @return список сомментариев
     */
    public Iterable<Comment> getComment(String key) {
        IssueRestClient issueRestClient = restClient.getIssueClient();
        if (null != issueRestClient){
            Issue issue = issueRestClient.getIssue(key).claim();
            if (null != issue) {
                return issue.getComments();
            }
        }
        return null;
    }

    /**
     * Получение списка вложений
     * @param key ключ или id
     * @return список вложений
     */
    public Iterable<Attachment> getAttachment(String key){
        IssueRestClient issueRestClient = restClient.getIssueClient();
        if (null != issueRestClient){
            Issue issue = issueRestClient.getIssue(key).claim();
            if (null != issue){
                return issue.getAttachments();
            }
        }
        return null;
    }

    /**
     * Получение списка переходов
     * @param key ключ или id задачи
     * @return список
     */
    public Iterable<Transition> getTransitions(String key){
        IssueRestClient issueRestClient = restClient.getIssueClient();
        if (null != issueRestClient){
            Issue issue = issueRestClient.getIssue(key).claim();
            if (null != issue) {
                return issueRestClient.getTransitions(issue).claim();
            }
        }
        return null;
    }

    @Override
    public void getInfo() {
        LogBus.info("jira");
    }

    @Override
    public void setInfo() {
        LogBus.info("jira");
    }
}
