package models;

public class Order {
    private String description;
    private double price;
    private int id;

    public Order(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Order() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
