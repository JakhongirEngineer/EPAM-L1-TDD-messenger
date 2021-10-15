package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.mailservers.ConsoleMailServer;
import com.epam.ld.module2.testing.mailservers.MailServer;
import com.epam.ld.module2.testing.Messenger;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

public class ConsoleDriver implements Driver{

    @Override
    public void run() {
        System.out.println("Console driver is running.");

        MailServer mailServer = new ConsoleMailServer(); // for console implementation
        TemplateEngine templateEngine = new TemplateEngine();

        Messenger messenger = new Messenger(mailServer, templateEngine);

        Template template = new Template();




        Client client = new Client();

        messenger.sendMessage(client, template);
    }
}
