/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import Model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Visagio
 */
public class TestUsers {
    
    ArrayList<User> usuarios;
    
    TestUsers() {
        this.usuarios =  new ArrayList<>();
        this.usuarios.add(new User("DefaultUser", "default", 0));
        this.usuarios.add(new User("ManagerUser", "manager", 1));
        this.usuarios.add(new User("AdminUser", "admin", 2));
    }
        
    }

