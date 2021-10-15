package com.epam.ld.module2.testing.drivers;


import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.template.Template;

public class FileDriver implements Driver {
    @Override
    public void run() {
        System.out.println("File driver is running");
    }

    @Override
    public Template createTemplate() {
        return null;
    }

    @Override
    public Client createClient(Template template) {
        return null;
    }
}
