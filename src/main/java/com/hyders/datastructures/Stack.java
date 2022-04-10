package com.hyders.datastructures;

import java.util.Arrays;

public class Stack {

    private static int size;
    private Object[] elements;

    private static final int  MAX_CAPACITY = 24;

    public Stack() {
        elements = new Object[MAX_CAPACITY];

    }

    public void push(Object obj) {
        ensureCapacity();
        elements[size++] = obj;
    }

    public Object pop(Object obj) {
        elements[size] = null;
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length==size) {
           elements = Arrays.copyOf(elements,2*size + 1);
        }
    }



}

