package org.fundacionjala.salesforce.ui.transporter;

import java.util.HashMap;
import java.util.Map;

public abstract class Transporter {

    private HashMap<String, String> pageUrl;

    /**
     * [JS] Constructor.
     */
    public Transporter() {
        pageUrl = new HashMap<>();
    }

    /**
     * [JS] Get the map of urls.
     * @return a map with the urls.
     */
    public Map<String, String> getPageUrl() {
        return pageUrl;
    }

    /**
     * [JS] Set a url into map.
     * @param key of url
     * @param url to set
     */
    public void setUrl(final String key, final String url) {
        pageUrl.put(key, url);
    }

    /**
     * [JS] Get a url into map.
     * @param key by find the element
     * @return a url that match with the key
     */
    public String getUrl(final String key) {
        return pageUrl.get(key);
    }
}
