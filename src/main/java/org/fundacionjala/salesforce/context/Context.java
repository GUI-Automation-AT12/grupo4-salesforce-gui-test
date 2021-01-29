package org.fundacionjala.salesforce.context;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fundacionjala.core.client.RequestManager;
import org.fundacionjala.salesforce.entities.Account;
import org.fundacionjala.salesforce.entities.Company;
import org.fundacionjala.salesforce.entities.Contact;
import org.fundacionjala.salesforce.entities.Opportunity;
import org.fundacionjala.salesforce.entities.Task;
import org.fundacionjala.salesforce.utils.AuthenticationUtils;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;

public class Context {
    private Contact contact;
    private ArrayList<Company> company;
    private Account account;
    private Opportunity opportunity;
    private Map<String, String> data;
    private Map<String, Map<String, String>> mapData;
    private ObjectMapper map;
    private List<Map> dataAsListMap;
    private Task task;

    private Set<String> editedFieldsCompany;
    /**
     * Constructor for the Context.
     */
    public Context() {
        this.contact = new Contact();
        this.editedFieldsCompany = new HashSet<String>();
        this.company = new ArrayList<Company>();
        this.account = new Account();
        this.opportunity = new Opportunity();
        this.task = new Task();
        this.data = new HashMap<>();
        this.mapData = new HashMap<>();
        this.map = new ObjectMapper();
        RequestManager.setRequestSpec(AuthenticationUtils.getLoggedReqSpec());
        data.put("instanceUrl", AuthenticationUtils.getInstanceUrl());
    }

    /**
     * Saves the data of form data in data.
     *
     * @param inputJson String
     */
    public void saveData(final String inputJson) throws JsonParseException, JsonMappingException, IOException {
        if (!inputJson.startsWith("[")) {
            mapData = map.readValue(inputJson, Map.class);
            toMap(mapData);
        } else {
            dataAsListMap = map.readValue(inputJson, List.class);
            Map<String, String> mapAux = new HashMap<>();
            int j = 0;
            for (Map dataList: dataAsListMap) {
                Object[] arrayKey = dataList.keySet().toArray();
                Object[] arrayValue = dataList.values().toArray();
                for (int i = 0; i < arrayKey.length; i++) {
                    mapAux.put(arrayKey[i].toString() + j + "", arrayValue[i].toString());
                }
                data.putAll(mapAux);
                j++;
            }
        }
    }

    /**
     * Converts Map of Maps into Map.
     *
     * @param mapToConvert map
     */
    private void toMap(final Map<String, Map<String, String>> mapToConvert) {
        Map<String, String> mapAux = new HashMap<String, String>();
        Set<String> keySet = mapToConvert.keySet();
        Iterator<String> iterator = keySet.iterator();
        Collection<Map<String, String>> mapCollection = mapToConvert.values();
        int i = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = String.format("%s", mapCollection.toArray()[i]);
            mapAux.put(key, value);
            i++;
        }
        data = mapAux;
    }


    /**
     * Gets the value of key given.
     *
     * @param key to get value
     * @return value of key
     */
    public String getValueData(final String key) {
        String value = "";
        if (mapData.containsKey(key)) {
            value = String.format("%s", mapData.get(key));
        }
        return value;
    }

    /**
     * Gets data map.
     *
     * @return data map
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Sets data map.
     *
     * @param dataToSet map
     */
    public void setData(final Map<String, String> dataToSet) {
        this.data = dataToSet;
    }

    /**
     *
     * @return task
     */
    public Task getTask() {
        return this.task;
    }

    /**
     *
     * @param  newTask
     */
    public void setTask(final Task newTask) {
        this.task = newTask;
    }

    /**
     *
     * @return account
     */
    public Account getAccount() {
        return account;
    }

    /**
     *
     * @param newAccount
     */
    public void setAccount(final Account newAccount) {
        this.account = newAccount;
    }


    /**
     *
     * @param newContact
     */
    public void setContact(final Contact newContact) {
        this.contact = newContact;
    }

    /**
     *
     * @return contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     *
     * @param newOpportunity
     */
    public void setOpportunity(final Opportunity newOpportunity) {
        this.opportunity = newOpportunity;
    }

    /**
     *
     * @return contact
     */
    public Opportunity getOpportunity() {
        return opportunity;
    }


    /**
     *
     * @return contact
     */
    public ArrayList<Company> getCompany() {
        return company;
    }

    /**
     *
     * @return Set keys.
     */
    public Set<String> getEditedFieldsCompany() {
        return editedFieldsCompany;
    }

    /**
     *
     * @param editedFieldsCompany
     */
    public void setEditedFieldsCompany(final Set<String> editedFieldsCompany) {
        this.editedFieldsCompany = editedFieldsCompany;
    }

}
