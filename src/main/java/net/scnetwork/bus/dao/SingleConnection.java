package net.scnetwork.bus.dao;

import net.scnetwork.bus.config.Config;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.enums.DaoEnums;
import net.scnetwork.bus.utils.LogBus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Одиночные подключения
 */
public class SingleConnection {
    private static Connection connection = null;

    /**
     * Определение подключения
     * @param enums тип подключения
     */
    public static void setConnection(DaoEnums enums) {
        switch (enums){
            case MYSQL:
                singleMysql();
                break;
            case ORACLE:
                singleOracle();
                break;
            case POSTGRESQL:
                singlePostgresql();
                break;
            default:
                break;
        }
    }

    private static void singlePostgresql(){
        try{
            Global global = Config.getInstance();
            if (null != global) {
                PostgreConfig config = global.getPostgreConfig();
                if (null != config) {
                    Class.forName("com.postgresql.Driver");
                    connection = DriverManager.getConnection(config.getJdbcUrl(), config.getUsername(), config.getPassword());
                }
            }
        } catch (NullPointerException | ClassNotFoundException | SQLException e){
            LogBus.writeLog(e);
        }
    }

    private static void singleOracle(){
        try{
            Global global = Config.getInstance();
            if (null != global) {
                OracleConfig config = global.getOracleConfig();
                if (null != config) {
                    Class.forName("com.oracle.Driver");
                    connection = DriverManager.getConnection(config.getJdbcUrl(), config.getUsername(), config.getPassword());
                }
            }
        } catch (NullPointerException | ClassNotFoundException | SQLException e){
            LogBus.writeLog(e);
        }
    }

    private static void singleMysql(){
        try{
            Global global = Config.getInstance();
            if (null != global) {
                OracleConfig config = global.getOracleConfig();
                if (null != config) {
                    Class.forName("com.mysql.Driver");
                    connection = DriverManager.getConnection(config.getJdbcUrl(), config.getUsername(), config.getPassword());
                }
            }
        } catch (NullPointerException | ClassNotFoundException | SQLException e){
            LogBus.writeLog(e);
        }
    }

    /**
     * Получение соединения
     * @return дескриптор соединения
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * Закрытие соединения
     * @throws SQLException исключение закрытия
     */
    public void close() throws SQLException {
        connection.close();
    }
}
