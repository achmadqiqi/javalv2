package models;

import entities.Product;

import java.io.Serial;
import java.io.Serializable;

public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = -5222773978859641903L;
    private Product product;
    private int jumlah;

    public Item(Product product, int jumlah) {
        this.product = product;
        this.jumlah = jumlah;
    }

    public Item() {
    }

    public int getJumlah() {
        return jumlah;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Double getSubtotal() {
        return getJumlah()*getProduct().getPrice();
    }
}
