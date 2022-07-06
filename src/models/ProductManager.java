package models;

import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList = new ArrayList<>();

    public void registerProduct(Product p) {
        productList.add(p);
    }

    public void printAllProduct() {
        for(Product p : productList){
            System.out.println(p);
        }
    }

    public void remove(Product p){
    productList.remove(p);
    }

    public Product findProductById(String Id) {
        for (Product product: productList){
            if (product.getId().equals(Id)){
                return product;
            }
        }
            return null;

    }

    public List<Product> getProductList() {
        return productList;
    }
    public List<Product> getAllProduct(){
        return getAllPoduct();
    }

}
