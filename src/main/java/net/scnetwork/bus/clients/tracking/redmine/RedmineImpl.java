package net.scnetwork.bus.clients.tracking.redmine;

import com.taskadapter.redmineapi.*;
import com.taskadapter.redmineapi.bean.Issue;
import com.taskadapter.redmineapi.bean.Project;
import net.scnetwork.bus.clients.tracking.ITracking;
import net.scnetwork.bus.utils.LogBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация клиента для Redmine
 */
public class RedmineImpl implements ITracking{
    private RedmineManager manager;

    /**
     * Коснтруктор
     * @param config конфигурация сервиса
     */
    public RedmineImpl(RedmineConfig config){
        manager = RedmineManagerFactory.createWithUserAuth(config.getUri(), config.getUsername(), config.getPassword());
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void setInfo() {
        LogBus.info("otrs");
    }

    /**
     * Получение списка проектов
     * @return список проектов
     * @throws RedmineException исключение системы Redmine
     */
    public List<Project> getProgects() throws RedmineException {
        ProjectManager projectManager = manager.getProjectManager();
        if (null != projectManager) {
            return projectManager.getProjects();
        }
        return new ArrayList<>();
    }

    /**
     * Получение списка задач
     * @param projectKey ключ проекта
     * @param id идентификатор
     * @param include дополнительные параметры
     * @return список задач
     * @throws RedmineException -
     */
    public List<Issue> getIssues(String projectKey, Integer id, Include include) throws RedmineException {
        IssueManager issueManager = manager.getIssueManager();
        if (null != issueManager){
            return issueManager.getIssues(projectKey, id, include);
        }
        return new ArrayList<>();
    }
}
