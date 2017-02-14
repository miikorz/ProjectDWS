/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alumno
 */
@Stateless
public class ProductDao implements ProductDaoLocal {
   
    @PersistenceContext(unitName = "projectdwsPU")
    EntityManager em;

    @Override
    public List<Product> listProducts() {
        List<Product> lista = em.createNamedQuery("product.findAll").getResultList();
        return lista;
    }
}
