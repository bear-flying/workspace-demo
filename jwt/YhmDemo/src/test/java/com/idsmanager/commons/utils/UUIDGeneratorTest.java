package com.idsmanager.commons.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
  * @author Shengzhao Li
  */
public class UUIDGeneratorTest {

    @Test
    public void testGenerate() throws Exception {

        final String uuid = UUIDGenerator.generate();
        assertNotNull(uuid);
    }
}