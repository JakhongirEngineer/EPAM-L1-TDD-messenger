package com.epam.ld.module2.testing.drivers;

public class ConsoleDriver implements Driver{
    @Override
    public void run() {
        System.out.println("Console driver is running.");
    }
}
