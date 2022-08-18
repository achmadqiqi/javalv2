package models;

import entities.Customer;
import entities.Product;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = -7863997837616689122L;
    private Customer customer;
    private String invoice;
    private List<Item> items =new ArrayList<>();

    public double getTotal(){
        double total = 0;
        for (Item i : items){
            total += i.getSubtotal();
        }
        return total;
    }


    public Order()     {
        invoice = randomInvoice();
        setCustomer(new Customer("2","Qiqi","Kediri","1010","1","08656123","qiqi@gmail.com"));
    }
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", invoice='" + invoice + '\'' +
                '}';
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

     public Integer setOrderId() {
        return setOrderId();
    }


    private static String randomInvoice(){
        Random rnd = new Random();
        int angka = rnd.nextInt(1000);
        return  "PDO"+angka;
    }

    public void setInvoice() {
        this.invoice = invoice;
    }

    public String getInvoice() {
        return invoice;
    }


//    public void cetakInvoice() {
//
//        System.out.println(shop.getName());
//        double total=0;
//        for (Item i:itemList ) {
//            System.out.printf(""+i.getProduct().getName()+"| "
//                    +"| "+i.getProduct().getPrice()+"| "+i.getJumlah()+"| "+i.getSubtotal()+"\n");
//            if (PromoManager.isPromo(i.getProduct())){
//
//            }
//            total += i.getSubtotal();
//        }
//        System.out.println("................................");
//        System.out.printf("TOTAL : "+total+"\n");
//    }
}
