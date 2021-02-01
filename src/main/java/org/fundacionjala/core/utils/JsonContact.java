package org.fundacionjala.core.utils;

import org.fundacionjala.salesforce.entities.Contact;
import org.fundacionjala.salesforce.entities.User;
import org.json.simple.parser.ParseException;

import java.util.Map;

public final class JsonContact extends JsonReader {

    private static String jsonPath = "src/main/java/org/fundacionjala/salesforce/config/json/Contact.json";
    private static JsonContact environment;
    private Contact contact;
    private Map<String, User> userList;

    /**
     * Json User constructor.
     */
    private JsonContact() {
        super(jsonPath);
        //contact.processInformation(convertToMap());
    }

    /**
     * This method returns the only one instance of JsonUser.
     * @return a JsonUser.
     */
    public static JsonContact getInstance() {
        if (environment == null) {
            environment = new JsonContact();
        }
        return environment;
    }

    /**
     * This method converts the Json to a map.
     * @return Map of the Json
     */
    private Map<String, String> convertToMap() {
        try {
            return (Map<String, String>) JsonReader.jsonArrayFromJsonFile().get(0);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method returns the contact.
     * @return User
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * This method converts the Json to a map.
     * @param alias
     * @return Map of the Json
     */
    public Map<String, String> getDataAsAMap(final String alias) {
        return JsonReader.getData(alias);
    }
}
