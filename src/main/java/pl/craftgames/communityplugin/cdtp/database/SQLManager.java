package pl.craftgames.communityplugin.cdtp.database;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.craftgames.communityplugin.cdtp.CDTP;
import pl.craftgames.communityplugin.cdtp.user.User;

import java.sql.*;
import java.util.UUID;

public class SQLManager {

    private CDTP plugin;

    private Connection connection;
    private Statement statement;
    private String sqlTablePrefix = "cdtp_";

    // public String generateStringAutoInc(){
    //     if(!GenConf.DATABASE.equals(Database.FILE)) return "INT PRIMARY KEY AUTO_INCREMENT"; else return "INTEGER PRIMARY KEY AUTOINCREMENT";
    // }
    //public String generateDefVal(){
    //     if(!GenConf.DATABASE.equals(Database.FILE)) return "0"; else return "null";
    // }
    public SQLManager(CDTP plugin, String host, int port, String user, String password, String name) {
        this.plugin = plugin;

        // switch(GenConf.DATABASE) {
        //     case FILE:
        Bukkit.getLogger().info("[SQLite] Connecting to SQLite database ...");
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + "cdtp");
            if (this.connection != null) {
                Bukkit.getLogger().info("[SQLite] Connected to SQLite successfully!");
                this.startWork();
            }
        } catch (ClassNotFoundException ex) {
            Bukkit.getLogger().info("[SQLite] Connecting with SQLite failed! We were unable to load driver 'org.sqlite.JDBC'.");
        } catch (SQLException | InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            Bukkit.getLogger().info("[SQLite] Connecting with SQLite failed! Permission error: " + ex.getMessage());
        }
        // break;
           /* case MYSQL:
                Bukkit.getLogger().info("[MySQL] Connecting to MySQL database ...");

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + name + "?autoReconnect=true", user, password);
                    this.statement = this.connection.createStatement();

                    Bukkit.getLogger().info("[MySQL] Connected to MySQL successfully!");
                    this.startWork();
                } catch(SQLException ex) {
                    Bukkit.getLogger().exceptionThrown(ex);
                } catch(ClassNotFoundException ex) {
                    Bukkit.getLogger().info("[MySQL] Connecting with MySQL failed! We were unable to load driver 'com.mysql.jdbc.Driver'.");
                }
                break;
            default:
                Bukkit.getLogger().severe("[MySQL] Invalid database type '" + GenConf.DATABASE.name() + "'!");
                break;
        }*/
    }

    private void startWork() {
        // Create tables is they doesn't exists
        this.createTables();
    }

    private void createTables() {
        Bukkit.getLogger().info("[DB] Creating tables if not exists ...");

        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + sqlTablePrefix + "players`"
                    + "(username VARCHAR(16),"
                    + "kills INT,"
                    + "deaths INT,"
                    + "money INT,"
                    + "PRIMARY KEY(username));";
            statement = this.connection.createStatement();
            statement.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    /**
     * Adds player to database.
     * It does not check if player already is in database!
     *
     * @param player instance of UUID class.
     */
    public void addPlayer(Player player) {
        try {
            statement = this.connection.createStatement();
            statement.execute("INSERT OR IGNORE INTO `" + sqlTablePrefix + "players` VALUES('" + player.getName() + "', '" + 0 + "', '" + 0 + "', '" + 0 + "')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePlayer(String playername, PlayerColumns columns, String value) {

        try {
            statement = this.connection.createStatement();
            statement.executeUpdate("UPDATE `" + sqlTablePrefix + "players` SET `" + columns.toString().toLowerCase() + "` = '" + value + "' WHERE `username` = '" + playername + "'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void incrementColumn(String playername, PlayerColumns columns, int value) {

        try {
            statement = this.connection.createStatement();
            String query = "UPDATE `" + sqlTablePrefix + "players` SET `" + columns.toString().toLowerCase() + "` = " + columns.toString().toLowerCase() + " + " + value + " WHERE `username` = '" + playername + "'";
            System.out.println("Aktualizuje "+query);
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public boolean isConnectionClosed() {
        try {
            return this.connection == null || this.connection.isClosed();
        } catch (SQLException ex) {
            return true;
        }
    }

    public void closeConnection() {
        try {
            if (!isConnectionClosed()) {
                this.connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            return result;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            statement = this.connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public boolean execute(String query) {
        try {
            statement = this.connection.createStatement();
            return statement.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public User getPlayer(Player p) {
        try {
            statement = this.connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM `" + sqlTablePrefix + "players` WHERE `username`='" + p.getName() + "'");
            result.next();
            String username = result.getString("username");
            int kills = result.getInt("kills");
            int deaths = result.getInt("deaths");
            int money = result.getInt("money");
            System.out.println("Pobrane wartosci to "+kills+ " "+ deaths+" "+ money);
            return new User(username, kills, deaths, money);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


