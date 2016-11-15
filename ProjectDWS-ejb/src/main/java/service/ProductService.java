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
    private boolean productExist;

    static {
        productList.add(new Product(0, 25, "PowerfullServer", "desc1", 60));
        productList.add(new Product(1, 55, "StandardServer", "desc2", 30));
        productList.add(new Product(2, 30, "FastServer", "desc3", 40));
        productList.add(new Product(3, 10, "HeavyServer", "desc4", 80));
    }

    @Override
    public ArrayList listProducts() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        productExist = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(product.getName())) {
                productExist = true;
            }
        }
        if (!productExist) {
            productList.add(product);
        }
    }

    @Override
    public Product findProductById(Product productToUpdate) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == productToUpdate.getProductID()) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateProduct(Product productToUpdate) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == productToUpdate.getProductID()) {
                productList.set(i, productToUpdate);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(Product productToDelete) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == productToDelete.getProductID()) {
                productList.remove(i);
                break;
            }
        }
    }

}
