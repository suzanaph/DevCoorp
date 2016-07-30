/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Manuel
 */
// Lista que contem todos os usários cadastrados 
@RequestScoped
@Named("registeredusers")
public class RegisteredUsers implements Serializable {

    private String username, password;
    private int profile;
    private List<User> users = new ArrayList<>();
  

    public RegisteredUsers() {
        this.users.add(new User("client", "1234", 1));
        this.users.add(new User("organizer", "1234", 2));
        this.users.add(new User("admin", "1234", 3));
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    @Override
    public String toString(){
String resp="";
        for (User user : this.users) {
           resp =resp+user.getUsername()+"\n";
        }
     return  resp;
}
  
}
