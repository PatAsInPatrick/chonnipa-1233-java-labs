package ngohlumdoun.chonnipa.lab7;

interface RunnerStatsCollector {
    public void displayRunningStats();

    public void displayHeartRates();
}

interface HealthMonitorer {
    public void displaySleepHours();
}

public class AppleWatchNike extends AppleWatch implements RunnerStatsCollector, HealthMonitorer {
    private double pace;
    private double totalDistance;
    private double time;
    private double avgHeartRate;
    private double maxHeartRate;
    private double avgSleepHours;

    // Constructor
    public AppleWatchNike(String color, double price, String modelName) {
        super(color, price, modelName);
    }

    // Constructor
    public AppleWatchNike(String color, double price, String modelName, double totalDistance, double avgHeartRate,
            double avgSleepHours) {
        super(color, price, modelName);
        this.totalDistance = totalDistance;
        this.avgHeartRate = avgHeartRate;
        this.avgSleepHours = avgSleepHours;
    }

    public void displayRunningStats() {
        System.out.printf("Total distance run: %.2f km", totalDistance);
        System.out.println();
    }

    public void displayHeartRates() {
        System.out.printf("Average heart rate: %.2f bpm", avgHeartRate);
        System.out.println();
    }

    public void displaySleepHours() {
        System.out.printf("Average sleep duration: %.2f hours", avgSleepHours);
        System.out.println();
    }

    @Override
    public String toString() {
        String result = "AppleWatchNike(color: " + color + " price:" + price + " model name:" + getModelName()
                + " distance: " + totalDistance + " km)";
        return result;
    }
}
