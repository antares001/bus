package net.scnetwork.bus.enums;

/**
 * Типы записи в лог
 * <ol>
 *     <li>LOCAL - запись в файл лога</li>
 *     <li>POSTGRESQL - запись в БД PostgreSQL</li>
 *     <li>MYSQL - запись в БД MySQL</li>
 *     <li>ORACLE - запись в БД Oracle</li>
 *     <li>SQLITE - запись в БД Sqlite</li>
 *     <li>SYSLOG - запись в системный журнал</li>
 * </ol>
 */
public enum  LogEnums {
    LOCAL, POSTGRESQL, MYSQL, ORACLE, SQLITE, SYSLOG, LOGSTASH;
}
