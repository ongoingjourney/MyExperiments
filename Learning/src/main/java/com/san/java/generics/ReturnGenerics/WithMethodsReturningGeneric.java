package com.san.java.generics.ReturnGenerics;

import java.util.List;

public class WithMethodsReturningGeneric<T> {
    public <T> T singleReturnVal(T param) {
        return param;
    }

    public <T extends String> List<T> listReturnValue(List<T> param) {
        List<T> list = new java.util.LinkedList<>();
        list.addAll(param);
        list.addAll(param);
        return list;
    }
}
