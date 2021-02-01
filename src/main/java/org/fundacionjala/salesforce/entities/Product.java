package org.fundacionjala.salesforce.entities;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String idProduct;
    private String name;
    private String code;

    /**
     * Constructor.
     */
    public Product() {
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     *
     * @return type
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param newType
     */
    public void setCode(final String newType) {
        this.code = newType;
    }

    /**
     *
     * @return idAccount
     */
    public String getIdProduct() {
        return idProduct;
    }

    /**
     *
     * @param id
     */
    public void setIdProduct(final String id) {
        this.idProduct = id;
    }

    /**
     * Compose a strategy map.
     * @param productInformation
     * @return a map of strategyMap
     */
    private HashMap<String, Runnable> composeStrategySetter(final Map<String, String> productInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setName(productInformation.get("Name")));
        //strategyMap.put("Code", () -> setCode(productInformation.get("Code")));

        return strategyMap;
    }

    /**
     * Process Product's information.
     * @param productInformation
     */
    public void processInformation(final Map<String, String> productInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategySetter(productInformation);
        productInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }
}
