package com.epam.ld.module2.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {


    @ParameterizedTest
    @ValueSource(strings = {"address1,address2,address3","London,New York,Ottawa"})
    void whenAddressesIsSetAddressesPropertyIsInitializedTheSameValue(String addressToSet) {
        Client client = new Client();
        client.setAddresses(addressToSet);
        assertEquals(addressToSet,client.getAddresses());
    }

}