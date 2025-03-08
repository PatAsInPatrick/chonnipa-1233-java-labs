package ngohlumdoun.chonnipa.lab12;

import ngohlumdoun.chonnipa.lab7.MobileDevice;

import java.io.Serializable;

public class SmartPhone extends MobileDevice implements Serializable{
    protected String name, brand, color;
    protected double price;

    private static final long serialVersionUID = 1L;

    // Contructor
    public SmartPhone(String name, String brand, double price, String color) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public SmartPhone(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.color = null;
    }

    @Override
    public String toString() {
        return "SmartPhone: " + name + " (" + brand + ") " + price + " Baht";
    }

    @Override
    public boolean isWatch() {
        return false;
    }
}
