package net.scnetwork.bus.clients.tracking;

/**
 * Реализация для трекинговых систем
 */
public interface ITracking {
    /**
     * Получение информации
     */
    void getInfo();

    /**
     * Запись информации
     */
    void setInfo();
}
