package org.fundacionjala.core.utils;

import net.bytebuddy.implementation.bytecode.Throw;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public final class PasswordHelper {

    public static String encrypt(String s) {
        try {
            return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String s) {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        try {
            return new String(decode, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
