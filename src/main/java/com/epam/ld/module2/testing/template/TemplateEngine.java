package com.epam.ld.module2.testing.template;

import com.epam.ld.module2.testing.Client;
import com.epam.ld.module2.testing.NotAllRequiredKeysAreProvidedException;

import java.util.Map;

/**
 * The type Template engine.
 */
public class TemplateEngine {
    /**
     * Generate message string.
     *
     * @param template the template
     * @param client   the client
     * @return the string
     */
    public String generateMessage(Template template, Client client) {
        Map<String, String> providedKeyValues = client.getProvidedKeyValues(); // example: name => Alica, job => Software Engineer
        Map<String, String> keyValuesInTemplate = template.getKeyValues(); // example: name => null, job => null
        String generatedMessage = template.getBody(); // initial template body
        int providedKeyValueCounter = 0; // all placeholders must be provided, so counter is used to keep track of them

        for (Map.Entry<String,String> entry : providedKeyValues.entrySet()){
            if (keyValuesInTemplate.containsKey(entry.getKey())){
                generatedMessage = generatedMessage.replace("#{" +entry.getKey() + "}", entry.getValue());
                providedKeyValueCounter++;
            }
        }

        if (keyValuesInTemplate.size() == providedKeyValueCounter){
            return generatedMessage;
        } else {
            throw new NotAllRequiredKeysAreProvidedException("not each key is given");
        }
    }
}
