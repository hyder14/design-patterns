package com.hyders.practice.certification;

import java.util.HashMap;
import java.util.Map;

public class Choosy {
    public static void main(String[] args) {
        Map<Friends, String> hm = new HashMap<Friends, String>();
        hm.put(new Friends("Charis"), "Summer 2009");
        hm.put(new Friends("Draumur"), "Spring 2002");
        Friends f = new Friends(args[0]);
        System.out.println(hm.get(f));
    }
}
class Friends {
    String name;
    Friends(String n) { name = n; }


    @Override
    public int hashCode(){

        int prime = 31;
        int code = prime + prime * (name!=null? name.hashCode():1);
        return code;
    }

    @Override
    public boolean equals(Object that) {

        if (this==null || that ==null) {
            return false;
        }

        if (!(that instanceof Friends)) {
            return false;
        }

        return (name.equals(((Friends) that).name));

    }

}
