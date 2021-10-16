package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.drivers.enums.DriverType;

import java.util.Scanner;

public class DriverFactory {

    public Driver createDriver(String type){
        switch (type){
            case DriverType.CONSOLE:
                return new ConsoleDriver(new Scanner(System.in));
            case DriverType.FILE:
                return new FileDriver();
        }
        return null;
    }
}
