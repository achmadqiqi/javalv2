package entities;

import javax.xml.stream.Location;
import java.io.Serializable;

public class Customer implements Serializable {
    private String id, name, address, phone, longtitude, latitude, email;
    private Location location;

    public Customer(String text, String id, String name, String address, String longtitude, String latitude, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.email = email;
   //     this.location = location;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getLongtitude() {
        return longtitude;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    //    public Location getLocation() {
//        return location;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\''+
                '}';
    }
}
