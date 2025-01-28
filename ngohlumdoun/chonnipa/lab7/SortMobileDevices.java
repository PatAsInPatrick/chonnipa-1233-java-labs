package ngohlumdoun.chonnipa.lab7;

/**
 * Sort Mobile Devices Program:
 * SortMobileDevices to sort different types of mobile devices by considering
 * multiple attributes.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 24 Jan 2025 11:38 AM
 */

import java.util.Comparator;
import java.util.Arrays;

public class SortMobileDevices implements Comparator<MobileDevice> {
    public static void main(String[] args) {
        // Create array of mobile devices with test cases
        MobileDevice[] devices = new MobileDevice[7];

        // Different prices
        devices[0] = new IPadAir("Rose Gold", 19900.0, 64);
        devices[1] = new IPadAir("Silver", 24900.0, 256);

        // Same price, comparing storage
        devices[2] = new IPadAir("Space Gray", 19900.0, 128);
        devices[3] = new IPadAir("Silver", 19900.0, 64);

        // AppleWatches with different prices
        devices[4] = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");

        // Same price, comparing model names and then colors
        devices[5] = new AppleWatch("Space Gray", 12900.0, "Apple Watch Ultra");
        devices[6] = new AppleWatch("Gold", 12900.0, "Apple Watch Series 7");

        // Sort the devices using our comparator
        Arrays.sort(devices, new SortMobileDevices());

        // Display sorted devices
        System.out.println("Mobile devices sorted by multiple criteria:");
        for (MobileDevice device : devices) {
            System.out.println(device);
        }
    }

    // Check the type of an object by using instanceof operator
    @Override
    public int compare(MobileDevice device1, MobileDevice device2) {

        // Sort by price first
        int priceComparison = Double.compare(device1.getPrice(), device2.getPrice());
        if (priceComparison != 0)
            return priceComparison;

        // If both devices are iPad Air, comparing storage and then color
        if (device1 instanceof IPadAir && device2 instanceof IPadAir) {
            IPadAir ipadAir1 = (IPadAir) device1;
            IPadAir ipadAir2 = (IPadAir) device2;
            int storageComparison = Double.compare(ipadAir1.getStorage(), ipadAir2.getStorage());

            if (storageComparison != 0)
                return storageComparison;
            return ipadAir1.getColor().compareTo(ipadAir2.getColor());
        }

        // If both devices are Apple Watch, comparing the model name and then color
        if (device1 instanceof AppleWatch && device2 instanceof AppleWatch) {
            AppleWatch appleWatch1 = (AppleWatch) device1;
            AppleWatch appleWatch2 = (AppleWatch) device2;
            int modelComparison = appleWatch1.getModelName().compareTo(appleWatch2.getModelName());

            if (modelComparison != 0)
                return modelComparison;
            return appleWatch1.getColor().compareTo(appleWatch2.getColor());
        }

        // If devices are in different types, comparing color
        return device1.getColor().compareTo(device2.getColor());
    }
}
