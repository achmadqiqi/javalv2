package entities;

import java.io.Serializable;

public class Location implements Serializable {
    double lattitude, longtitude;

    public Location(double lattitude, double longtitude) {
        this.lattitude = lattitude;
        this.longtitude = longtitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
}
