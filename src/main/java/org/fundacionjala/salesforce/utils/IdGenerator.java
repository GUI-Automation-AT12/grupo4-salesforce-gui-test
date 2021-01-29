package org.fundacionjala.salesforce.utils;

import java.util.UUID;

public final class IdGenerator {

    private IdGenerator() {
    }

    /**
     * Utility method that generates an unique id.
     * @return UniqueId
     */
    public static String getUniqueId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
