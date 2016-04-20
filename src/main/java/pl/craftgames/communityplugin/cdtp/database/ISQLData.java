package pl.craftgames.communityplugin.cdtp.database;

import java.sql.Connection;

/**
 * Created by grzegorz2047 on 20.04.2016
 */
public interface ISQLData {
    Connection getDriver();

    String name();
}
