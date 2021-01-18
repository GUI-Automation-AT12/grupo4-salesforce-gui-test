package org.fundacionjala.core.utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.UnsupportedEncodingException;


public class PasswordHelperTest {

    @Test
    public void testPasswordEncrypt() {
        String encrypted = PasswordHelper.encrypt("password");
        Assert.assertEquals(encrypted, "cGFzc3dvcmQ=");
    }

    @Test
    public void testPasswordDecrypt() {
        String decrypted = PasswordHelper.decrypt("cGFzc3dvcmQ=");
        Assert.assertEquals(decrypted, "password");
    }
}