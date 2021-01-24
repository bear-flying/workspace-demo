package com.idsmanager.commons.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Shengzhao Li
 */
public class PasswordHandlerTest {

    @Test
    public void testRandomPassword() throws Exception {

        final String pwd = PasswordHandler.randomPassword();
        assertNotNull(pwd);
        assertTrue(pwd.length() == 12);
//        System.out.println(pwd);
    }
}