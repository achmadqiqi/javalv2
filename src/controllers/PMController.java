package controllers;

import entities.Product;
import models.ProductManager;

import java.util.List;

public class PMController {
    private ProductManager pm;
    public PMController(ProductManager pm) {
        this.pm = pm;
    }
    public void registerProduct(Product p) { pm.registerProduct(p); }
    public void printAllProduct() { pm.printAllProduct(); }
    public List<Product> getAllProducts() { return pm.getProductList(); }
    public Product findProductById(String id) { return pm.findProductById(id); }
}
