package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.drivers.enums.DriverType;

import java.util.Scanner;

public class DriverFactory {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param type defines which mode needs to be selected
     * @return depending on type, it returns either Console or File driver class.
     */
    public Driver createDriver(String type){
        switch (type){
            case DriverType.CONSOLE:
                return new ConsoleDriver(scanner);
            case DriverType.FILE:
                return new FileDriver(scanner);
            default: new ConsoleDriver(scanner);
        }
        return null;
    }
}
