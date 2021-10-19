package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.drivers.Driver;
import com.epam.ld.module2.testing.drivers.DriverFactory;
import com.epam.ld.module2.testing.drivers.enums.DriverType;

import java.util.Scanner;

public class Main {
    private static final  Scanner scanner = new Scanner(System.in);

    private static void introductionMessage(){
        System.out.println("You need to choose application mode.");
        System.out.println("Enter 1 for CONSOLE mode");
        System.out.println("Enter 2 for FILE mode");
        System.out.print("-> ");
    }

    /**
     * bootstrap method
     * @param args from command line
     */
    public static void main(String[] args) {

        DriverFactory driverFactory = new DriverFactory();
        Driver driver;
        introductionMessage();
        while (true){
            int modeOption = scanner.nextInt();
            if (modeOption == 1){
                driver = driverFactory.createDriver(DriverType.CONSOLE);
                break;
            } else if (modeOption == 2){
                driver =  driverFactory.createDriver(DriverType.FILE);
                break;
            } else {
                System.out.println("You need to choose either CONSOLE (1) or FILE (2) option");
            }
        }
        driver.run();
    }
}
