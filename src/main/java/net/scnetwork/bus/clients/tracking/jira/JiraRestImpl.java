package net.scnetwork.bus.clients.tracking.jira;

import com.atlassian.jira.rest.client.api.IssueRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.ServerInfo;
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

    @Override
    public void getInfo() {
        LogBus.info("jira");
    }

    @Override
    public void setInfo() {
        LogBus.info("jira");
    }
}
