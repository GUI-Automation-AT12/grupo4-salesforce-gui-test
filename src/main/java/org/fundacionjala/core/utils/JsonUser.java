package org.fundacionjala.core.utils;

import org.json.simple.parser.ParseException;

import java.util.Map;

public class JsonUser extends JsonReader {

    private static String jsonPath = "src/main/java/trello/config/json/User.json";
    private static JsonUser environment;
    private Map<String, String> jsonUser;

    /**
     * Json User constructor.
     */
    private JsonUser() {
        super(jsonPath);
        jsonUser = convertToMap();
    }

    /**
     * This method returns the only one instance of JsonUser.
     * @return
     */
    public static JsonUser getInstance() {
        if (environment == null) {
            environment = new JsonUser();
        }
        return environment;
    }

    /**
     * This method converts the Json to a map.
     * @return
     */
    private Map<String, String> convertToMap() {
        try {
            return (Map<String,String>) JsonReader.jsonArrayFromJsonFile().get(0);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method returns the name.
     * @return
     */
    public String getName() {
       return jsonUser.get("name");
    }

    /**
     * This method returns the email.
     * @return
     */
    public String getEmail() {
        return jsonUser.get("email");
    }

    /**
     * This method returns the password.
     * @return
     */
    public String getPassword() {
        return jsonUser.get("password");
    }

    /**
     * This method returns the username.
     * @return
     */
    public String getUserName() {
        return jsonUser.get("userName");
    }

    /**
     * This method returns the bibliography.
     * @return
     */
    public String getBibliography() {
        return jsonUser.get("bibliography");
    }

    /**
     * This method returns the token.
     * @return
     */
    public String getToken() {
        return jsonUser.get("token");
    }

    /**
     * This method returns the key.
     * @return
     */
    public String getKey() {
        return jsonUser.get("key");
    }
}
