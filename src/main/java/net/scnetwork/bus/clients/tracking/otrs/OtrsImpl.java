package net.scnetwork.bus.clients.tracking.otrs;

import net.scnetwork.bus.clients.tracking.ITracking;
import net.scnetwork.bus.utils.LogBus;

/**
 * Реализация клиента OTRS
 */
public class OtrsImpl implements ITracking{
    @Override
    public void getInfo() {
        LogBus.info("otrs");
    }

    @Override
    public void setInfo() {
        LogBus.info("otrs");
    }
}
