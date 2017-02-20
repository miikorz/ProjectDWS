/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import repository.UserDaoLocal;

/**
 *
 * @author fabio
 */
@Stateless
public class UserService implements UserServiceLocal {

    @EJB
    private UserDaoLocal userDao;

    @Resource
    private SessionContext contexto; 
    
    @Override
    public List<User> listUsers() {
        try {
            return userDao.listUsers();
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findUserById(User user) {
        try {
            return userDao.findUserById(user);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        try {
            userDao.addUser(user);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) {
        try {
            userDao.deleteUser(user);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            return userDao.updateUser(user);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }
}
