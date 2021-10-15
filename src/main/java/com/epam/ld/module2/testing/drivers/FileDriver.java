package com.epam.ld.module2.testing.drivers;


import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.Messenger;
import com.epam.ld.module2.testing.mailservers.FileMailServer;
import com.epam.ld.module2.testing.mailservers.MailServer;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.util.Scanner;


public class FileDriver implements Driver {
    private static final Scanner scanner = new Scanner(System.in);
    private String inputFileAbsolutePath;
    private String outputFileAbsolutePath;
    @Override
    public void run() {
        System.out.println("File driver is running");
        System.out.println("Provide absolute path of input file:");
        inputFileAbsolutePath = scanner.nextLine();
        System.out.println("Provide absolute path of output file:");
        outputFileAbsolutePath = scanner.nextLine();

//        MailServer mailServer = new FileMailServer();
//        TemplateEngine templateEngine = new TemplateEngine();
//        Messenger messenger = new Messenger(mailServer, templateEngine);
//
//        Template template = createTemplate();
//        Client client = createClient(template);
//        messenger.sendMessage(client, template);
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
