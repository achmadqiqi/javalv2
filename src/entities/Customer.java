package entities;

import javax.xml.stream.Location;

public class Customer {
    private String id, name;
    private Location location;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }


}
