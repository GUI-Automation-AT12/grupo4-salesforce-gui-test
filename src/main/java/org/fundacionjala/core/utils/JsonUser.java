package org.fundacionjala.core.utils;

import org.fundacionjala.salesforce.entities.User;
import org.json.simple.parser.ParseException;
import java.util.Map;

public final class JsonUser extends JsonReader {

    private static String jsonPath = "src/main/java/org/fundacionjala/salesforce/config/json/User.json";
    private static JsonUser environment;
    private User user;
    private Map<String, User> userList;

    /**
     * Json User constructor.
     */
    private JsonUser() {
        super(jsonPath);
        user.processInformation(convertToMap());
    }

    /**
     * This method returns the only one instance of JsonUser.
     *
     * @return a JsonUser.
     */
    public static JsonUser getInstance() {
        if (environment == null) {
            environment = new JsonUser();
        }
        return environment;
    }

    /**
     * This method converts the Json to a map.
     *
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
     * This method returns the user.
     * @return User
     */
    public User getUser() {
        return user;
    }
}
