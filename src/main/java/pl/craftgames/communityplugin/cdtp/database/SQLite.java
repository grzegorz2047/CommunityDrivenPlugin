package pl.craftgames.communityplugin.cdtp.database;

/**
 * Created by grzegorz2047 on 20.04.2016
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aleksander
 */
public class SQLite implements ISQLData {
    private final String dir;

    public SQLite(String dir) {
        this.dir = dir;
    }

    @Override
    public Connection getDriver() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            connection = DriverManager.getConnection("jdbc:sqlite:" + getDir());
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    @Override
    public String name() {
        return "sqlite";
    }

    public String getDir() {
        return this.dir;
    }
}