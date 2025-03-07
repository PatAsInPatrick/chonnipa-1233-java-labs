package ngohlumdoun.chonnipa.lab12;

import ngohlumdoun.chonnipa.lab7.MobileDevice;

public class SmartPhone {
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
    }
}
