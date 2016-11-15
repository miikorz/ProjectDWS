/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Product;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface ProductServiceLocal {
    
    ArrayList listProducts();
    
    void addProduct(Product product);

    public Product findProductById(Product productToUpdate);

    public void updateProduct(Product productToUpdate);
}
