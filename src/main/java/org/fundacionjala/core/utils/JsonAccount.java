package org.fundacionjala.core.utils;

import org.fundacionjala.salesforce.entities.Account;
import org.fundacionjala.salesforce.entities.User;
import org.json.simple.parser.ParseException;

import java.util.Map;

public final class JsonAccount extends JsonReader {

    private static String jsonPath = "src/main/java/org/fundacionjala/salesforce/config/json/Account.json";
    private static JsonAccount environment;
    private Account account;
    private Map<String, Account> userList;

    /**
     * Json User constructor.
     */
    private JsonAccount() {
        super(jsonPath);
        //account.processInformation(convertToMap());
    }

    /**
     * This method returns the only one instance of JsonUser.
     *
     * @return a JsonUser.
     */
    public static JsonAccount getInstance() {
        if (environment == null) {
            environment = new JsonAccount();
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
    public Account getAccount() {
        return account;
    }

    /**
     * This method converts the Json to a map.
     * @return Map of the Json
     */
    public Map<String, String> getDataAsAMap(final String alias) {
            return JsonReader.getData(alias);
    }
}
