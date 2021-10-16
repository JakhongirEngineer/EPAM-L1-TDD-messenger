package com.epam.ld.module2.testing.drivers;

import com.epam.ld.module2.testing.template.Template;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
}

