package com.hyders.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A basic implementation of Stack class
 */
public class Stack {

    private Object[] elements;
    private int size;

    public Stack(Object[] elements) {
        this.elements = elements;
        size = elements.length;
    }

    public void push(Object object) {
        ensureCapacity();
        elements[size++] = object;
    }

    public Object pop() {
        Object result = elements[--size];
        elements[size] = null; //eliminate obsolete reference
        return result;
    }


    private void ensureCapacity() {
        if (elements.length==size) {
            this.elements = Arrays.copyOf(elements, 2* size+ 1);
        }
    }


    public static void main(String[] args) {
        String[] elem = {"one", "two", "three"};
        Stack stack = new Stack(elem);
        System.out.println("Elements before pushing in stack: " + stack.toString());
        stack.push("four");
        System.out.println("Elements after pushing in stack: " + stack.toString());

        System.out.println("Elements before popping from stack: " + stack.toString());

            while (stack.size>0) {
                System.out.println(String.format("Popped item =%s", stack.pop()));
                System.out.println("Elements after popping from stack: " + stack.toString());
            }

    }

    @Override
    public String toString() {
        return String.format("Stack = %s", Arrays.toString(elements));

        /*Alternate approach*/
        /*
        List<Object> list = Arrays.stream(elements).collect(Collectors.toList());
        String str = list.stream().filter(x->x!=null).map(Object:: toString).collect(Collectors.joining(";"));
        return str;
        */

    }

}
