package entities;

import enums.ProductCategory;

import javax.swing.*;
import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 5789417225345326807L;
    private String id, name;
    private String category;
    private double price;
    private ImageIcon imageIcon;

    public Product(String id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;

    }
    //POJO Plain Old Java Object
    public Product(){

    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public ImageIcon getImageIcon() {
        return imageIcon;
    }
    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", imageIcon=" + imageIcon +
                '}';
    }
}

