package ngohlumdoun.chonnipa.lab7;

public abstract class MobileDevice {
    protected String color;
    protected double price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract boolean isWatch();
}
