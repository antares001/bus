package net.scnetwork.bus.dao;

/**
 * Настройка пула подключений
 */
public interface IConfigDaoPool extends IConfigDao{

    /**
     * Получение количества подключений при старте
     * @return количество подключений
     */
    int getInitialLimit();

    /**
     * Запись количества подключений при старте
     * @param initialLimit количечтво подключений
     */
    void setInitialLimit(int initialLimit);

    /**
     * Получение максимального количества подключений
     * @return максимальное количество подключений
     */
    int getMaxLimit();

    /**
     * Запись максимального количества подключений
     * @param maxLimit максимальное количество подключений
     */
    void setMaxLimit(int maxLimit);
}
