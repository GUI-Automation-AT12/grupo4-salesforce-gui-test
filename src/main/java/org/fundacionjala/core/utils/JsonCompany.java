package org.fundacionjala.core.utils;

import org.fundacionjala.salesforce.entities.Account;
import org.fundacionjala.salesforce.entities.Company;
import org.json.simple.parser.ParseException;

import java.util.Map;

public class JsonCompany extends JsonReader {

    private static String jsonPath = "src/main/java/org/fundacionjala/salesforce/config/json/Company.json";
    private static JsonCompany environment;
    private Company company;
    private Map<String, Account> companyList;

    /**
     * This method returns the file's path.
     *
     */
    protected JsonCompany() {
        super(jsonPath);
    }

    /**
     * This method returns the only one instance of JsonUser.
     *
     * @return a JsonUser.
     */
    public static JsonCompany getInstance() {
        if (environment == null) {
            environment = new JsonCompany();
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
    public Company getAccount() {
        return company;
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
