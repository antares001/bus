package net.scnetwork.bus.clients.tracking.redmine;

import com.taskadapter.redmineapi.ProjectManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Project;
import net.scnetwork.bus.clients.tracking.ITracking;
import net.scnetwork.bus.utils.LogBus;

import java.util.List;

/**
 * Реализация клиента для Redmine
 */
public class RedmineImpl implements ITracking{
    private RedmineManager manager;

    public RedmineImpl(RedmineConfig config){
        manager = RedmineManagerFactory.createWithUserAuth(config.getUri(), config.getUsername(), config.getPassword());
    }

    @Override
    public void getInfo() {
        LogBus.info("otrs");
    }

    @Override
    public void setInfo() {
        LogBus.info("otrs");
    }

    public List<Project> getProgects() throws RedmineException {
        ProjectManager projectManager = manager.getProjectManager();
        if (null != projectManager) {
            return projectManager.getProjects();
        }
        return null;
    }
}
