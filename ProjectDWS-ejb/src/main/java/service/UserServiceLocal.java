/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.User;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author fabio
 */
@Local
public interface UserServiceLocal {

    ArrayList listUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User findUserById(User user);

    String hola(String parameter);
}
