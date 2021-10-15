package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.drivers.enums.DriverType;

public class ModeSingleton {
    private DriverType driverType;

    private ModeSingleton(){}

    private static class ModeSingletonHelper{
        private static final ModeSingleton INSTANCE = new ModeSingleton();
    }

    public static ModeSingleton getModeSingleton(){
        return ModeSingletonHelper.INSTANCE;
    }

    public DriverType getDriverType() {
        return driverType;
    }

    public void setDriverType(DriverType driverType) {
        this.driverType = driverType;
    }
}
