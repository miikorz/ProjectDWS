/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Product;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ProductService implements ProductServiceLocal {

    private static ArrayList<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(0, 25, "PowerfullServer", " desc1", 60));
        productList.add(new Product(1, 55, "StandardServer", " desc2", 30));
        productList.add(new Product(2, 30, "FastServer", " desc3", 40));
        productList.add(new Product(3, 10, "HeavyServer", " desc4", 80));
    }

    @Override
    public ArrayList listProducts() {
        return productList;
    }
    
    @Override
    public void addProduct(Product product){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(product.getName())) {
                break;
            } else {
                productList.add(product);
                
            }
        }
    }
    
}
