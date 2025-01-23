package ngohlumdoun.chonnipa.lab7;

public class AppleWatch extends MobileDevice {
    private String modelName;

    public AppleWatch(String color, double price, String modelName) {
        this.color = color;
        this.price = price;
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public boolean isWatch() {
        return true;
    }

    @Override
    public String toString() {
        String result = "AppleWatch [color=" + color + ", price=" + price + ", modelName=" + modelName + "]";
        return result;
    }
}
