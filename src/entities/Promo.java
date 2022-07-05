package entities;

import java.util.Date;

public class Promo {
    private Product product;
    private int discount;
    private Date startDate;
    private Date stopDate;
    private Outlet outlet;

    public Promo(Product product, int discount, Date startDate, Date stopDate) {
        this.product = product;
        this.discount = discount;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public Promo(Product product, int discount, Date startDate, Date stopDate, Outlet outlet) {
        this.product = product;
        this.discount = discount;
        this.startDate = startDate;
        this.stopDate = stopDate;
        this.outlet = outlet;
    }
}
