package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.NotAllRequiredKeysAreProvidedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@EnabledOnOs({OS.WINDOWS, OS.LINUX, OS.MAC})
@EnabledForJreRange(min = JRE.JAVA_8)
@ExtendWith(MockitoExtension.class)
class TemplateEngineTest {

    @Mock
    Template template;
    @Mock
    Client client;

    @DisplayName("user provides only all the necessary values")
    @Tag("key_value")
    @Test
    void whenClientProvidesOnlyAllOfThePlaceholdersGenerateMessageCorrectly() {
        Map<String,String> clientProvidedKeyValues = new HashMap<>();
        clientProvidedKeyValues.put("hobby", "reading");
        clientProvidedKeyValues.put("name", "John");
        when(client.getProvidedKeyValues()).thenReturn(clientProvidedKeyValues);

        Map<String,String> templateKeyValues = new HashMap<>();
        templateKeyValues.put("hobby",null);
        templateKeyValues.put("name",null);
        when(template.getKeyValues()).thenReturn(templateKeyValues);
        String templateBody = "Hello, my name is #{name}. I love #{hobby}.";
        when(template.getBody()).thenReturn(templateBody);

        TemplateEngine templateEngine = new TemplateEngine();
        String generatedMessage = templateEngine.generateMessage(template, client);
        assertEquals("Hello, my name is John. I love reading.", generatedMessage);
    }


    @DisplayName("user provides all and more key values")
    @Tag("key_value")
    @Test
    void whenAllNecessaryAndExtraPlaceholdersProvidedMessageIsGeneratedCorrectly() {
        Map<String,String> clientProvidedKeyValues = new HashMap<>();
        clientProvidedKeyValues.put("hobby", "reading");
        clientProvidedKeyValues.put("name", "John");
        clientProvidedKeyValues.put("occupation", "dentist");
        clientProvidedKeyValues.put("favourite band", "Imagine Dragons");
        clientProvidedKeyValues.put("favourite sport", "body building");

        when(client.getProvidedKeyValues()).thenReturn(clientProvidedKeyValues);

        Map<String,String> templateKeyValues = new HashMap<>();
        templateKeyValues.put("hobby",null);
        templateKeyValues.put("name",null);
        when(template.getKeyValues()).thenReturn(templateKeyValues);
        String templateBody = "Hello, my name is #{name}. I love #{hobby}.";
        when(template.getBody()).thenReturn(templateBody);

        TemplateEngine templateEngine = new TemplateEngine();
        String generatedMessage = templateEngine.generateMessage(template, client);
        assertEquals("Hello, my name is John. I love reading.", generatedMessage);
    }

    @DisplayName("user does not provide required value")
    @Tag("key_value")
    @Test
    void whenAtLeastOneRequiredPlaceholderIsNotProvidedGenerateMessageThrowsAnException() {
        Map<String,String> clientProvidedKeyValues = new HashMap<>();
        clientProvidedKeyValues.put("hobby", "reading");
        clientProvidedKeyValues.put("occupation", "dentist");
        clientProvidedKeyValues.put("favourite band", "Imagine Dragons");
        clientProvidedKeyValues.put("favourite sport", "body building");

        when(client.getProvidedKeyValues()).thenReturn(clientProvidedKeyValues);

        Map<String,String> templateKeyValues = new HashMap<>();
        templateKeyValues.put("hobby",null);
        templateKeyValues.put("name",null);
        when(template.getKeyValues()).thenReturn(templateKeyValues);
        String templateBody = "Hello, my name is #{name}. I love #{hobby}.";
        when(template.getBody()).thenReturn(templateBody);

        TemplateEngine templateEngine = new TemplateEngine();

        assertThrows(
                NotAllRequiredKeysAreProvidedException.class,
                () -> templateEngine.generateMessage(template,client),
                "Not all required keys are provided."
        );
    }
}