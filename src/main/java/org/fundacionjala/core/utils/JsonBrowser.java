package org.fundacionjala.core.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fundacionjala.core.selenium.Browser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class JsonBrowser {

    private static Map<String, Browser> browserMap;
    private static final String JSON_FILE_PATH =
            "src/main/java/org/fundacionjala/core/config/jsonFiles/BrowserProperties.json";

    private JsonBrowser() {
    }

    private static List<Browser> getBrowsersListFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(JSON_FILE_PATH), new TypeReference<>() { });
    }

    /**
     * Get a Map of Browsers' Properties from json file.
     * @return browserList
     */
    public static Map<String, Browser> getBrowsersMap() throws IOException {
        if (browserMap == null) {
            browserMap =  new HashMap<>();
            for (Browser browser: getBrowsersListFromJson()) {
                browserMap.put(browser.getName(), browser);
            }
        }
        return browserMap;
    }
}
