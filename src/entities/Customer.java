package entities;

import javax.xml.stream.Location;
import java.io.Serial;
import java.io.Serializable;

public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = 4010558382033140732L;
    private String id, name, address, phone, longtitude, latitude;
    private String email;
    private Location location;

    public Customer(String id, String name, String address, String longtitude, String latitude, String phone, String email) {
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
                ", addres='" + address + '\''+
                ", phone='" + phone + '\''+
                ", lontitude='" + longtitude + '\''+
                ", latitude='" + latitude + '\''+
                ", email='" + email + '\''+
                '}';
    }
}
