package com.epam.ld.module2.testing.mailservers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileMailServer implements MailServer{
    private final String outputFileAbsolutePath;
    public FileMailServer(String outputFileAbsolutePath) {
        this.outputFileAbsolutePath = outputFileAbsolutePath;
    }

    @Override
    public void send(String addresses, String messageContent) {
        List<String> result = Arrays.stream(addresses.split(","))
                .map(address -> "The below message is sent to the address: " + address + "\n" +
                        messageContent).collect(Collectors.toList());

        try {
            Files.write(Path.of(outputFileAbsolutePath),result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
