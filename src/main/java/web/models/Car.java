package web.models;

public class Car {

    private String vendor;
    private String model;
    int ageMake;

    //constructors
    public Car(String vendor) {
        this.vendor = vendor;
    }

    public Car(String vendor, String model) {
        this.vendor = vendor;
        this.model = model;
    }

    public Car(String vendor, String model, int ageBorn) {
        this.vendor = vendor;
        this.model = model;
        this.ageMake = ageBorn;
    }

    //getters and setters

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public int getAgeMake() {
        return ageMake;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAgeMake(int ageMake) {
        this.ageMake = ageMake;
    }
}
