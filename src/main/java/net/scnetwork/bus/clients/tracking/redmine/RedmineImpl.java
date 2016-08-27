package net.scnetwork.bus.clients.tracking.redmine;

import net.scnetwork.bus.clients.tracking.ITracking;
import net.scnetwork.bus.utils.LogBus;

/**
 * Реализация клиента для Redmine
 */
public class RedmineImpl implements ITracking{
    @Override
    public void getInfo() {
        LogBus.info("otrs");
    }

    @Override
    public void setInfo() {
        LogBus.info("otrs");
    }
}
