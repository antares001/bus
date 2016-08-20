package net.scnetwork.bus.dao;

/**
 * Интерфейс для конфигураций подключения к БД
 */
public interface IConfigDao {
    /**
     * Получение url
     * @return url
     */
    String getJdbcUrl();

    /**
     * Запись url
     * @param jdbcUrl url
     */
    void setJdbcUrl(String jdbcUrl);

    /**
     * Получение имени пользователя
     * @return имя пользователя
     */
    String getUsername();

    /**
     * Запись имени пользователя
     * @param username имя пользователя
     */
    void setUsername(String username);

    /**
     * Получение пароля пользователя
     * @return пароль пользователя
     */
    String getPassword();

    /**
     * Запись пароля пользователя
     * @param password пароль пользователя
     */
    void setPassword(String password);
}
