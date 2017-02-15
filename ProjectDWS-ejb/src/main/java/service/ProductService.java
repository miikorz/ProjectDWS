/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import repository.ProductDaoLocal;

/**
 *
 * @author alumno
 */
@Stateless
public class ProductService implements ProductServiceLocal {

    @EJB
    private ProductDaoLocal productDao;
    
    @Resource
    private SessionContext contexto; 

    @Override
    public List<Product> listProducts() {
        try {
            return productDao.listProducts();
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Product findProductById(Product product) {
        try {
            return productDao.findProductById(product);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addProduct(Product product) {
        try {
            productDao.addProduct(product);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Product product) {
        try {
            productDao.deleteProduct(product);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            return productDao.updateProduct(product);
        } catch (Exception e) {
            contexto.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

}
