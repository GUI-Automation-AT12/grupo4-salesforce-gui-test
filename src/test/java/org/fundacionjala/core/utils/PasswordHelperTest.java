package org.fundacionjala.core.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordHelperTest {

    @Test
    public void testPasswordEncrypt() {
        String encrypted = PasswordHelper.encrypt("control123");
        Assert.assertEquals(encrypted, "Y29udHJvbDEyMw==");
    }

    @Test
    public void testPasswordDecrypt() {
        String decrypted = PasswordHelper.decrypt("cGFzc3dvcmQ=");
        Assert.assertEquals(decrypted, "password");
    }
}