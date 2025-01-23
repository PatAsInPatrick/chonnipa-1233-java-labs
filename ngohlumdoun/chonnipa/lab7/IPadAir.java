package ngohlumdoun.chonnipa.lab7;

public class IPadAir extends MobileDevice {
    private double storage;
    private static String CHIP_NAME = "Apple M2";

    public IPadAir(String color, double price, double storage) {
        this.color = color;
        this.price = price;
        this.storage = storage;
    }

    public double getStorage() {
        return storage;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public static String getChipName() {
        return CHIP_NAME;
    }

    @Override
    public boolean isWatch() {
        return false;
    }

    @Override
    public String toString() {
        String result = "IPadAir [color=" + color + ", price=" + price + ", storage=" + storage + ", chip=" + getChipName()
                + "]";
        return result;
    }
}
