package com.epam.ld.module2.testing.mailservers;

import java.util.Arrays;

public class ConsoleMailServer implements MailServer {

    /**
     *
     * @param addresses  comma separated addresses string: "address1,address2,address3"
     * @param messageContent the message content
     */
    @Override
    public void send(String addresses, String messageContent) {
        String[] addressArray = addresses.split(",");
        Arrays.stream(addressArray)
                .forEach(address -> {
                    System.out.println("the below message is sent to address: " + address);
                    System.out.println(messageContent);
                });
    }
}
