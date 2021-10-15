package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.MailServer;
import com.epam.ld.module2.testing.Messenger;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

public class ConsoleDriver implements Driver{

    @Override
    public void run() {
        System.out.println("Console driver is running.");

        MailServer mailServer = new MailServer();
        TemplateEngine templateEngine = new TemplateEngine();

        Messenger messenger = new Messenger(mailServer, templateEngine);

        Client client = new Client();
        Template template = new Template();

        messenger.sendMessage(client, template);
    }
}
