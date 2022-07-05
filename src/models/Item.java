package models;

import entities.Product;

public class Item {
    private Product product;
    private int jumlah;

    public Item(Product product, int jumlah) {
        this.product = product;
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Product getProduct() {
        return product;
    }

    public Double getSubtotal() {
        return getJumlah()*getProduct().getPrice();
    }
}
