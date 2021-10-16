package com.epam.ld.module2.testing.template;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @Test
    void whenTemplateBodyIsSetCheckKeyValues() {
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}");
        Map<String, String> keyValues = template.getKeyValues();
        boolean containsName = keyValues.containsKey("name");
        boolean containsHobby = keyValues.containsKey("hobby");
        assertTrue(containsName && containsHobby );
    }

    @Test
    void whenTemplateBodyIsSetCheckMapValuesSetToNull(){
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}");
        Map<String, String> keyValues = template.getKeyValues();
        String name = keyValues.get("name");
        String hobby = keyValues.get("hobby");
        assertAll(
                "Checking map is initialized with null values",
                () -> assertNull(name, "name is not set to null"),
                () -> assertNull(hobby, "hobby is not set to null")
        );
    }

    @Test
    void whenTemplateBodyIsSetWithUniquePlaceholdersCheckMapSizeIsEqualToNumberOfUniquePlaceholders(){
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}");
        Map<String, String> keyValues = template.getKeyValues();
        assertEquals(2, keyValues.size());
    }

    @Test
    void whenTemplateBodyIsSetWithDuplicatedPlaceholdersCheckMapSizeIsEqualToNumberOfUniquePlaceholders(){
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}. My #{hobby} is getting better.");
        Map<String, String> keyValues = template.getKeyValues();
        assertEquals(2, keyValues.size());
    }

    @Test
    void whenTemplateBodyIsSetCheckIfItIsSetTheGivenValue(){
        Template template = new Template();
        String setValue = "My name is #{name}, and I like #{hobby}. My #{hobby} is getting better.";
        template.setBody(setValue);
        String getValue = template.getBody();
        assertEquals(setValue,getValue);
    }


    @Test
    void whenTemplateBodyIsSetCheckIfKeyValuesMapIsPopulatedWithCorrectKeys() {
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}. My #{hobby} is getting better.");
        Map<String, String> keyValues = template.getKeyValues();
        List<String> placeholders = new ArrayList<>(Arrays.asList("name", "hobby"));
        placeholders.forEach(placeholder -> {
            assertTrue(keyValues.containsKey(placeholder));
        });
    }
}