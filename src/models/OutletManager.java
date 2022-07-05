package models;

import entities.Outlet;

import java.util.ArrayList;
import java.util.List;

public class OutletManager {
    private List<Outlet> OutletList = new ArrayList<>();
    public void addOutlet(Outlet outlet) {
        OutletList.add(outlet);
    }
}
