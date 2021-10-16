package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.mailservers.ConsoleMailServer;
import com.epam.ld.module2.testing.mailservers.MailServer;
import com.epam.ld.module2.testing.Messenger;
import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;

import java.util.*;

public class ConsoleDriver implements Driver{
    private  Scanner scanner;// = new Scanner(System.in);

    public ConsoleDriver(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        System.out.println("Console driver is running.");

        MailServer mailServer = new ConsoleMailServer();
        TemplateEngine templateEngine = new TemplateEngine();
        Messenger messenger = new Messenger(mailServer, templateEngine);

        Template template = createTemplate();
        Client client = createClient(template);
        messenger.sendMessage(client, template);
    }


    public Template createTemplate() {
        Template template = new Template();
        StringBuilder bodyBuilder = new StringBuilder();
        System.out.println("Please, type the template body in the console.");
        System.out.println("Example: I am #{name} and I work as a #{job} ...");
        System.out.println("Once you are done, please, press ENTER twice.");
        while (true){
            String currentLine = scanner.nextLine();
            if (currentLine.length() == 0){
                break;
            }
            bodyBuilder.append(currentLine);
        }
        template.setBody(bodyBuilder.toString());
        return template;
    }


    public Client createClient(Template template) {
        Map<String,String> providedKeyValues = new HashMap<>();
        for (String key : template.getKeyValues().keySet()){
            System.out.print(key + ": ");
            String currentKeyValue = scanner.nextLine();
            providedKeyValues.put(key,currentKeyValue);
        }

        Client client = new Client();

        client.setProvidedKeyValues(providedKeyValues);
        client.setAddresses(getAddresses());
        return client;
    }

    private String getAddresses(){
        System.out.println("Enter Addresses where you want to send the message to:");
        System.out.println("Once you are done, press ENTER twice");
        List<String> addresses = new ArrayList<>();
        while (true){
            String currentAddress = scanner.nextLine();
            if (currentAddress.length() > 0){
                addresses.add(currentAddress);
            } else {
                break;
            }
        }

        StringBuilder addressesStringBuilder = new StringBuilder();
        addresses.forEach(address -> addressesStringBuilder.append(address).append(","));
        return addressesStringBuilder.toString();
    }
}
