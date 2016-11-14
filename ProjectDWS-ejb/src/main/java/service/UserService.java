/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.User;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author fabio
 */
@Stateless
public class UserService implements UserServiceLocal {

    private static ArrayList<User> list = new ArrayList<>();
    private static int lastId = 6;

    static {
        list.add(new User(1,"fabio950","admin","Fabio","Pérez","Golderos",24,"La Cañada, Paterna","fperez950@gmail.com",628786053));
        list.add(new User(2,"miikorz","admin","Miguel","Burdeos","Tébar",25,"Mislata","miikorz@gmail.com",678543405));
    }
    
    @Override
    public ArrayList listUsers() {
        return list;
    }

    @Override
    public void addUser(User user) {
        boolean found = false;
        
        for (int i = 0; list.size() > i; i++) {
           if(!(list.get(i).getUser().equals(user.getUser()))) {
               found = false;
           } else {
               found = true;
               break;
           }
        }
        
        if(found == false){
            user.setId(lastId);
            lastId++;
            list.add(user);
        }
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; list.size() > i; i++) {
            if (list.get(i).getId() == user.getId()) {
                list.set(i, user);
                break;
            }
        }
    }

    @Override
    public void deleteUser(User user) {
        for (int i = 0; list.size() > i; i++) {
            if (list.get(i).getId() == user.getId()) {
                list.remove(i);
                break;
            }
        }
    }

    @Override
    public User findUserById(User user) {
        for (int i = 0; list.size() > i; i++) {
            if (list.get(i).getId() == user.getId()) {
                return list.get(i);
            }
        }

        return null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
