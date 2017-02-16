/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="product")
@NamedQueries({
@NamedQuery(name="product.findAll", query = "SELECT p FROM Product p ORDER BY p.productID")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    
    @Column(nullable=false)
    private int stock;
    
    @Column(nullable=false, length=45)
    private String name; 
    
    @Column(nullable=false, length=45)
    private String description;
    
    @Column(nullable=false)
    private double price;
    

    public Product(int productID, int stock, String name, String description, double price) {
        this.productID = productID;
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(int stock, String name, String description, double price) {
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {

    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
}
