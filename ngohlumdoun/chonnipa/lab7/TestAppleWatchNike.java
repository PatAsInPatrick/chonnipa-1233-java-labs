package ngohlumdoun.chonnipa.lab7;

public class TestAppleWatchNike {
    public static void main(String[] args) {
        AppleWatchNike nikeWatch = new AppleWatchNike("Space Gray", 12900.0, "Nike SE GPS", 42.5, 75, 7.5);
        System.out.println(nikeWatch); // Display basic information

        // Display health and fitness metrics
        nikeWatch.displayRunningStats();
        nikeWatch.displayHeartRates();
        nikeWatch.displaySleepHours();

        // Test inheritance from AppleWatch
        System.out.println("Is this a watch? " + nikeWatch.isWatch()); // Should print true

        // Test polymorphism
        AppleWatch baseWatch = nikeWatch; // Upcasting
        System.out.println("Through base reference: " + baseWatch);
    }
}
