package com.epam.ld.module2.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@EnabledOnOs({OS.WINDOWS, OS.LINUX, OS.MAC})
@EnabledForJreRange(min = JRE.JAVA_8)
class ClientTest {


    @DisplayName("check addresses set")
    @Tag("addresses")
    @ParameterizedTest
    @ValueSource(strings = {"address1,address2,address3","London,New York,Ottawa"})
    void whenAddressesIsSetAddressesPropertyIsInitializedTheSameValue(String addressToSet) {
        Client client = new Client();
        client.setAddresses(addressToSet);
        assertEquals(addressToSet,client.getAddresses());
    }

    @DisplayName("check provided values are correctly set")
    @Tag("provided_values")
    @Test
    void whenPlaceholdersAndValuesAreProvidedProvidedKeyValueGetsTheSameValue(){
        Client client = new Client();
        Map<String,String> placeholderKeyValues = new HashMap<>();
        placeholderKeyValues.put("name","John");
        placeholderKeyValues.put("hobby", "swimming");
        client.setProvidedKeyValues(placeholderKeyValues);

        assertEquals(placeholderKeyValues, client.getProvidedKeyValues());
    }

}