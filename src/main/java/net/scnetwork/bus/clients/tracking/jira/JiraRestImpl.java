package net.scnetwork.bus.clients.tracking.jira;

import net.scnetwork.bus.clients.tracking.ITracking;
import net.scnetwork.bus.utils.LogBus;

/**
 * Реализация rest клиента jira
 */
public class JiraRestImpl implements ITracking{
    @Override
    public void getInfo() {
        LogBus.info("jira");
    }

    @Override
    public void setInfo() {
        LogBus.info("jira");
    }
}
