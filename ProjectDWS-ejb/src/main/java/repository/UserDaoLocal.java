/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface UserDaoLocal {
    List<User> listUsers();

    void addUser(User user);

    void deleteUser(User user);

    User findUserById(User user);

    public User updateUser(User user);
    
    List<User> orderByName();
}
