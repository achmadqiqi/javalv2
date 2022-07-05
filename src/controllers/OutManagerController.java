package controllers;

import entities.Outlet;
import models.OutletManager;

public class OutManagerController {
    private OutletManager otm;
    public OutManagerController(OutletManager otm) {
        this.otm = otm;
    }

    public void addOutlet(Outlet outlet) {
        otm.addOutlet(outlet);
    }
}
