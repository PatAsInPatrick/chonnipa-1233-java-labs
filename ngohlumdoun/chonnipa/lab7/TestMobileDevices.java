package ngohlumdoun.chonnipa.lab7;

/**
 * Test Mobile Devices Program:
 * Test the implementations of these three classes
 * Class MobileDevice, Class IPadAir, Class AppleWatch
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 23 Jan 2025 04:30 PM
 */

public class TestMobileDevices {
    public static void main(String[] args) {
        IPadAir ipadAir1 = new IPadAir("Rose Gold", 19900.0, 64);
        IPadAir ipadAir2 = new IPadAir("Silver", 24900.0, 256);

        AppleWatch appleWatch1 = new AppleWatch("Silver", 9400.0, "Apple Watch Nike SE GPS");

        System.out.println("IPadAir chip name is " + IPadAir.getChipName());

        if (ipadAir2.isWatch())
            System.out.println(ipadAir2 + " is a watch");
        else
            System.out.println(ipadAir2 + " is not a watch");

        comparePrice(ipadAir1, ipadAir2);
        comparePrice(ipadAir1, appleWatch1);
    }

    public static void comparePrice(MobileDevice device1, MobileDevice device2) {
        double price1 = device1.getPrice();
        double price2 = device2.getPrice();

        if (price1 < price2)
            System.out.println(device1 + " is cheaper than " + device2);
        else if (price1 > price2)
            System.out.println(device2 + " is cheaper than " + device1);
        else
            System.out.println(device1 + " is as cheap as " + device2);
    }
}
