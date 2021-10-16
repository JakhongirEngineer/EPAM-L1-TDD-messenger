package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.drivers.enums.DriverType;

import java.util.Scanner;

public class DriverFactory {
    private static final Scanner scanner = new Scanner(System.in);
    public Driver createDriver(String type){
        switch (type){
            case DriverType.CONSOLE:
                return new ConsoleDriver(scanner);
            case DriverType.FILE:
                return new FileDriver(scanner);
        }
        return null;
    }
}
