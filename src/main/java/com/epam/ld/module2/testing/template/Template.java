package com.epam.ld.module2.testing.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Template.
 */
public class Template {

    private String body;
    private Map<String, String> keyValues;

    public Template() {
        this.body = "";
        this.keyValues = new HashMap<>();
    }

    public Template(String body) {
        this.body = body;
        this.keyValues = new HashMap<>();
    }

    public Template(String body, Map<String, String> keyValues) {
        this.body = body;
        this.keyValues = keyValues;
    }

    private void initializeKeysInKeyValues(){
        // example: "Thank you Mr/Ms #{name}. You will be working as a #{occupation}"
        // result in keyValues: name => null, occupation => null; because they are not provided yet.
        List<String> keys = extractKeysFromBody();
        keys.forEach(k -> keyValues.put(k, null));
    }

    private List<String> extractKeysFromBody(){
        List<String> keys = new ArrayList<>();
        StringBuilder currentKey = new StringBuilder();
        int i = 0;
        while ( i < body.length() ) {
            if (i < body.length() - 3 && body.charAt(i) == '#' && body.charAt(i+1) == '{') {
                i += 2; // skip
                while ( i < body.length() && body.charAt(i) != '}') {
                    currentKey.append(body.charAt(i++));
                }
                if (i < body.length() && body.charAt(i) == '}'){
                    keys.add(currentKey.toString());
                    currentKey = new StringBuilder(); // reinitialize for a new key
                }
            } else {
                i++;
            }
        }
        return keys;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
        this.keyValues = new HashMap<>();
        initializeKeysInKeyValues();
    }

    public Map<String, String> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(Map<String, String> keyValues) {
        this.keyValues = keyValues;
    }

}
