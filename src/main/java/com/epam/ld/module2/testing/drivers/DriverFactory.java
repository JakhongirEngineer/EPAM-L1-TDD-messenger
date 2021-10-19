package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.drivers.enums.DriverType;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DriverFactory {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     *
     * @param type defines which mode needs to be selected
     * @return depending on type, it returns either Console or File driver class.
     */
    public Driver createDriver(String type){
        if (DriverType.FILE.equals(type)) {
            return new FileDriver(scanner);
        }
        return new ConsoleDriver(scanner);
    }
}
