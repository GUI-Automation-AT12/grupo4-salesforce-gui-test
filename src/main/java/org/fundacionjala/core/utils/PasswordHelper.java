package org.fundacionjala.core.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * [RH] Password helper.
 */
public class PasswordHelper {

    private static String charSetName = "utf-8";

    protected PasswordHelper() {
    }

    /**
     * [RH] This method encrypts a password.
     * @param password
     * @return encrypted password.
     */
    public static String encrypt(final String password) {
        try {
            return Base64.getEncoder().encodeToString(password.getBytes(charSetName));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * [RH] This method decrypts a password.
     * @param password
     * @return decrypted password.
     */
    public static String decrypt(final String password) {
        byte[] decode = Base64.getDecoder().decode(password.getBytes());
        try {
            return new String(decode, charSetName);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
