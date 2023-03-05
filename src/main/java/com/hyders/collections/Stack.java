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
    private Object minimum = null;

    public Stack(Object[] elements) {

        for (Object element:elements) {
            if (minimum==null) {
                minimum=element;
            }
            if ((element instanceof Integer) && (Integer)element<(Integer) minimum) {
                minimum = element;
            }
        }
        this.elements = elements;
        size = elements.length;
    }

    public void push(Object object) {
        ensureCapacity();
        if ((object instanceof Integer) && (Integer)object<(Integer) minimum) {
            minimum = object;
        }
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


    private Object min(){

        return minimum;
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


            Object[] elements = {1,2,3,4,5,6,7,8,9};

            Stack stack1 = new Stack(elements);

            stack1.push(-5);

            System.out.println("minimum:" + stack1.min());

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
