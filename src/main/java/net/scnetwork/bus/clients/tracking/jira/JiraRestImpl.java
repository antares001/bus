package net.scnetwork.bus.clients.tracking.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import net.scnetwork.bus.clients.tracking.ITracking;
import net.scnetwork.bus.utils.LogBus;

/**
 * Реализация rest клиента jira
 */
public class JiraRestImpl implements ITracking{
    private JiraRestClient restClient;

    @Override
    public void getInfo() {
        LogBus.info("jira");
    }

    @Override
    public void setInfo() {
        LogBus.info("jira");
    }
}
