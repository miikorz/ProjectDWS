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

    @Override
    public void addProduct(Product product) {
        em.persist(product);
    }

    @Override
    public void deleteProduct(Product product) {
        product = findProductById(product);
        em.remove(product);
    }

    @Override
    public Product findProductById(Product product) {

        return em.find(Product.class, product.getProductID());
    }

    @Override
    public Product updateProduct(Product product) {
        return em.merge(product);
    }

    @Override
    public List<Product> orderByPrice() {
        List<Product> lista = em.createNamedQuery("product.orderByPrice").getResultList();
        return lista;
    }
}
