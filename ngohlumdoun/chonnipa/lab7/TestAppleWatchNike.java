package ngohlumdoun.chonnipa.lab7;

/**
 * Test Apple WatchNike Program:
 * Test the implementations of this class
 * Class AppleWatchNike which is a subclass of AppleWatch
 * that implements two interfaces
 * interface RunnerStatsCollector , interface HealthMonitorer
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 24 Jan 2025 10:30 AM
 */

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
