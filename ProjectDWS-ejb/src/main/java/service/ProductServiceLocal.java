/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface ProductServiceLocal {
    
    public List<Product> listProducts();
    
    public void addProduct(Product product);

    public Product findProductById(Product productToUpdate);

    public Product updateProduct(Product productToUpdate);

    public void deleteProduct(Product productToDelete);
}
