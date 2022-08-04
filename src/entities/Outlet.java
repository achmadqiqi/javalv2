package entities;

public class Outlet {
    private String id, alamat;

    public Outlet(String id, String alamat) {
        this.id = id;
        this.alamat = alamat;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getId() {
        return id;
    }
}
