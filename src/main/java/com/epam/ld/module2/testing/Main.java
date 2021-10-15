package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.drivers.Driver;
import com.epam.ld.module2.testing.drivers.DriverFactory;
import com.epam.ld.module2.testing.drivers.enums.DriverType;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("You need to choose application mode.");
        System.out.println("Enter 1 for CONSOLE mode");
        System.out.println("Enter 2 for FILE mode");

        DriverFactory driverFactory = new DriverFactory();
        Driver driver;
       // ModeSingleton modeSingleton = ModeSingleton.getModeSingleton();
        while (true){
            int modeOption = scanner.nextInt();
            if (modeOption == 1){
                driver = driverFactory.createDriver(DriverType.CONSOLE);
              //  modeSingleton.setDriverType(DriverType.CONSOLE);
                break;
            } else if (modeOption == 2){
                driver = driverFactory.createDriver(DriverType.FILE);
              //  modeSingleton.setDriverType(DriverType.FILE);
                break;
            } else {
                System.out.println("You need to choose either CONSOLE (1) or FILE (2) option");
            }
        }
        driver.run();
    }
}
