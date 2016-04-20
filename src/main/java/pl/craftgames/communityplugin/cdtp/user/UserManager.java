package pl.craftgames.communityplugin.cdtp.user;

import java.util.HashMap;

/**
 * Created by grzegorz2047 on 20.04.2016
 */
public class UserManager {
    private HashMap<String, User> users = new HashMap<String, User>();

    public HashMap<String, User> getUsers() {
        return users;
    }
}
