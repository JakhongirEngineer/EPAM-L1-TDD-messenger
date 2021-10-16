package com.epam.ld.module2.testing.template;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@EnabledOnOs({OS.WINDOWS, OS.LINUX, OS.MAC})
@EnabledForJreRange(min = JRE.JAVA_8)
class TemplateTest {

    @DisplayName("check if template body is parsed correctly")
    @Tag("template_body")
    @Test
    void whenTemplateBodyIsSetCheckKeyValues() {
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}");
        Map<String, String> keyValues = template.getKeyValues();
        boolean containsName = keyValues.containsKey("name");
        boolean containsHobby = keyValues.containsKey("hobby");
        assertTrue(containsName && containsHobby );
    }

    @DisplayName("check map values are set to null")
    @Tag("map_values")
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

    @DisplayName("map size check when unique placeholders are provided")
    @Tag("unique_placeholders")
    @Test
    void whenTemplateBodyIsSetWithUniquePlaceholdersCheckMapSizeIsEqualToNumberOfUniquePlaceholders(){
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}");
        Map<String, String> keyValues = template.getKeyValues();
        assertEquals(2, keyValues.size());
    }

    @DisplayName("map size check when duplicated placeholders are provided")
    @Tag("duplicated_placeholders")
    @Test
    void whenTemplateBodyIsSetWithDuplicatedPlaceholdersCheckMapSizeIsEqualToNumberOfUniquePlaceholders(){
        Template template = new Template();
        template.setBody("My name is #{name}, and I like #{hobby}. My #{hobby} is getting better.");
        Map<String, String> keyValues = template.getKeyValues();
        assertEquals(2, keyValues.size());
    }

    @DisplayName("check template body is set correctly")
    @Tag("template_body")
    @Test
    void whenTemplateBodyIsSetCheckIfItIsSetTheGivenValue(){
        Template template = new Template();
        String setValue = "My name is #{name}, and I like #{hobby}. My #{hobby} is getting better.";
        template.setBody(setValue);
        String getValue = template.getBody();
        assertEquals(setValue,getValue);
    }


    @DisplayName("check map is correctly populated with values")
    @Tag("map")
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