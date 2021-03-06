/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface ProductDaoLocal {

    List<Product> listProducts();

    void addProduct(Product product);

    void deleteProduct(Product product);

    Product findProductById(Product product);

    public Product updateProduct(Product product);
    
    List<Product> orderByPrice();
}
