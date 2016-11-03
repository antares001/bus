package net.scnetwork.bus.clients.tracking;

/**
 * Реализация для трекинговых систем
 */
public interface ITracking {
    /**
     * Получение информации issue
     */
    String getInfo();

    /**
     * Запись информации
     */
    void setInfo();
}
