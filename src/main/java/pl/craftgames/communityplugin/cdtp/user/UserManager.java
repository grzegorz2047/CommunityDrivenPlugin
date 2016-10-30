package pl.craftgames.communityplugin.cdtp.user;

import org.mozilla.javascript.Scriptable;
import pl.grzegorz2047.databaseapi.SQLUser;

import java.util.HashMap;

/**
 * Created by grzegorz2047 on 20.04.2016
 */
public class UserManager {
    private HashMap<String, User> usersstats = new HashMap<String, User>();
    private HashMap<String, SQLUser> usersCG = new HashMap<String, SQLUser>();

    public HashMap<String, User> getUsersstats() {
        return usersstats;
    }

    public HashMap<String, SQLUser> getUsersCG() {
        return usersCG;
    }
}
