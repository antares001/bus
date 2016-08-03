package net.scnetwork.bus.config;

import net.scnetwork.bus.enums.DaoEnums;

public class Global {
    private Modules modules;
    private DaoEnums dao;

    public Modules getModules() {
        return modules;
    }

    public void setModules(Modules modules) {
        this.modules = modules;
    }

    public DaoEnums getDao() {
        return dao;
    }

    public void setDao(DaoEnums dao) {
        this.dao = dao;
    }
}
