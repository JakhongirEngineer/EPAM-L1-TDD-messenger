package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.drivers.enums.DriverType;

public class DriverFactory {

    public Driver createDriver(DriverType type){
        switch (type){
            case CONSOLE:
                return new ConsoleDriver();
            case FILE:
                return new FileDriver();
        }
        return null;
    }
}
