package models;

import entities.Shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
private List<Item> itemList =new ArrayList<>();
private Shop shop;


    public Order(Shop shop) {
        this.shop = shop;
    }

    public Order() {

    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void cetakInvoice() {

        System.out.println(shop.getName());
        double total=0;
        for (Item i:itemList ) {
            System.out.printf(""+i.getProduct().getName()+"| "
                    +"| "+i.getProduct().getPrice()+"| "+i.getJumlah()+"| "+i.getSubtotal()+"\n");
            if (PromoManager.isPromo(i.getProduct())){

            }
            total += i.getSubtotal();
        }
        System.out.println("................................");
        System.out.printf("TOTAL : "+total+"\n");
    }
}
