package ngohlumdoun.chonnipa.lab12;

public class Tablet {
    protected String name, brand, color;
    protected double price;

    // Contructor
    public Tablet(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public Tablet(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = null;
    }
}
