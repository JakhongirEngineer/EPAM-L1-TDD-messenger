package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.template.Template;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleDriverTest {

    @Test
    void whenConsoleModeIsRunCheckUserInputForTemplateBody(){
        String input = "I am #{name} and I work as a #{job}.";
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn(input).thenReturn("");
        ConsoleDriver consoleDriver = new ConsoleDriver(scanner);
        Template template = consoleDriver.createTemplate();
        assertEquals(input, template.getBody());
    }
    @Test
    void whenConsoleModeIsRunCheckUserInputForKeyValuePairs(){
        String input0 = "I am #{name} and I work as a #{job}.";
        String input1 = "John";
        String input2 = "doctor";
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn(input0).thenReturn("").thenReturn(input1).thenReturn(input2).thenReturn("");
        ConsoleDriver consoleDriver = new ConsoleDriver(scanner);
        Template template = consoleDriver.createTemplate();

        Client client = consoleDriver.createClient(template);

        Map<String, String> providedKeyValues = client.getProvidedKeyValues();

        assertAll("check values are set correctly",
                () -> assertEquals("doctor", providedKeyValues.get("job")),
                () -> assertEquals("John", providedKeyValues.get("name"))
                );
    }


    @Test
    void whenConsoleModeIsRunCheckUserInputForAddresses(){
        String input0 = "I am #{name} and I work as a #{job}.";
        String input1 = "John";
        String input2 = "doctor";
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine())
                .thenReturn(input0).thenReturn("") // for body
                .thenReturn(input1).thenReturn(input2) // for values
                .thenReturn("London").thenReturn("New York").thenReturn(""); // for addresses

        ConsoleDriver consoleDriver = new ConsoleDriver(scanner);
        Template template = consoleDriver.createTemplate();

        Client client = consoleDriver.createClient(template);

        Map<String, String> providedKeyValues = client.getProvidedKeyValues();
        String addresses = client.getAddresses();
        String expectedAddresses = "London,New York,";

        assertAll("check values are set correctly",
                () -> assertEquals("doctor", providedKeyValues.get("job")),
                () -> assertEquals("John", providedKeyValues.get("name")),
                () -> assertEquals(expectedAddresses, addresses)
        );
    }


}

