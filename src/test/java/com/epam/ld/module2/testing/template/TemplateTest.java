package com.epam.ld.module2.testing.template;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void getBody() {

    }

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
    void getKeyValues() {

    }

    @Test
    void setKeyValues() {

    }
}