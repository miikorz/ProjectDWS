/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fabio
 */
@Stateless
public class UserDao implements UserDaoLocal {

    @PersistenceContext(unitName = "projectdwsPU")
    EntityManager em;

    @Override
    public List<User> listUsers() {
        List<User> lista = em.createNamedQuery("user.findAll").getResultList();
        return lista;
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        user = findUserById(user);
        em.remove(user);
    }

    @Override
    public User findUserById(User user) {

        return em.find(User.class, user.getId());
    }

    @Override
    public User updateUser(User user) {
        return em.merge(user);
    }
}
