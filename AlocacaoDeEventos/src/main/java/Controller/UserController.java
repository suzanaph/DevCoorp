/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.RegisteredUsers;
import Model.User;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Manuel
 */
public class UserController {

    /**
     * Creates a new instance of UserController
     */
    private static UserController instance = null;

    protected UserController() {
    }

    public static UserController getInstance() {
        if (instance == null) {
            return new UserController();
        }
        return instance;
    }

    public static User findUser(List<User> users, User u) {
        for (User user : users) {
            if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
                return user;
            }
        }
        return null;
    }


    public static void register(List<User> users, User u) {
        users.add(u);
    }

    public static void unregister(List<User> users, User u) {
        users.remove(u);
    }

}
