package com.epam.ld.module2.testing;

import java.util.Map;

/**
 * The type Client.
 */
public class Client {
    private String addresses;
    private Map<String,String> providedKeyValues;

    /**
     * Gets addresses.
     *
     * @return the addresses
     */
    public String getAddresses() {
        return addresses;
    }

    /**
     * Sets addresses.
     *
     * @param addresses the addresses
     */
    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public Map<String, String> getProvidedKeyValues() {
        return providedKeyValues;
    }

    public void setProvidedKeyValues(Map<String, String> providedKeyValues) {
        this.providedKeyValues = providedKeyValues;
    }
}
