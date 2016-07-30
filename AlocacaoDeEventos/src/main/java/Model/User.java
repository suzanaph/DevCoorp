/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import Controller.UserController;

/**
 *
 * @author Visagio
 */
@ManagedBean()
@RequestScoped()
@Named("user")

public class User implements Serializable {

    @ManagedProperty(value = "#{registeredusers}")
    private RegisteredUsers registered;
    UserController control = UserController.getInstance();

    public RegisteredUsers getRegistered() {
        return registered;
    }

    public void setRegistered(RegisteredUsers registered) {
        this.registered = registered;
    }

    /**
     * Creates a new instance of UserBean
     */
    private String username, password;
    private int profile;

    public User() {
        this.username = "client";
        this.password = "1234";
        this.profile = 1;
    }

    public User(String username, String password, int profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    /**
     *
     *
     */
    @PostConstruct
    public void init() {
        registered = new RegisteredUsers();

    }
//Escolhe a pagina certa de acordo com o perfil do usuario 

    public String login() {
        System.out.println(this.registered.getUsers());
        String pagina = "LoginErrorScreen";
        User usr = control.findUser(this.registered.getUsers(), this);
        if (usr != null) {
            this.profile = usr.getProfile();
            switch (profile) {
                case 1:
                    pagina = "StartScreen.xhtml";
                    break;
                case 2:
                    pagina = "OrganizerScreen.xhtml";
                    break;
                case 3:
                    pagina = "AdminScreen.xhtml";
                    break;
            }
        }
        return pagina;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return this.username;
    }

}
