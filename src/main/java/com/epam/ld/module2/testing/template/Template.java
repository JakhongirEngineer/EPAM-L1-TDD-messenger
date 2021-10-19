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

    // example: "Thank you Mr/Ms #{name}. You will be working as a #{occupation}"
    // result in keyValues: name => null, occupation => null; because they are not provided yet.
    private void initializeKeysInKeyValues(){
        List<String> keys = extractKeysFromBody();
        keys.forEach(k -> keyValues.put(k, null));
    }

    private List<String> extractKeysFromBody(){
        List<String> keys = new ArrayList<>();
        StringBuilder currentKey = new StringBuilder();
        int index = 0;
        while ( index < body.length() ) {
            if (index < body.length() - 3 && body.charAt(index) == '#' && body.charAt(index+1) == '{') {
                index += 2; // skip
                while ( index < body.length() && body.charAt(index) != '}') {
                    currentKey.append(body.charAt(index++));
                }
                if (index < body.length() && body.charAt(index) == '}'){
                    keys.add(currentKey.toString());
                    currentKey = new StringBuilder(); // reinitialize for a new key
                }
            } else {
                index++;
            }
        }
        return keys;
    }

    public String getBody() {
        return body;
    }


    /**
     *
     * @param body is set for template
     */
    public void setBody(String body) {
        this.body = body;
        this.keyValues = new HashMap<>();
        initializeKeysInKeyValues();
    }
    public Map<String, String> getKeyValues() {
        return keyValues;
    }
}
