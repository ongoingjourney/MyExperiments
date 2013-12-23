package com.san.java.generics.ReturnGenerics;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WithMethodsReturningGenericTest {
    private WithMethodsReturningGeneric<String> withMethodsReturningGeneric = new WithMethodsReturningGeneric<>();

    @Test
    public void testSingleReturnVal() throws Exception {
        String testString = "hello";
        Assert.assertEquals(testString, withMethodsReturningGeneric.singleReturnVal(testString));
    }

    @Test
    public void testListReturnValue() throws Exception {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Assert.assertEquals(list.size() * 2, withMethodsReturningGeneric.listReturnValue(list).size());
    }
}
