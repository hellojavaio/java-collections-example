package edu.maskleo.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(10);
        set.add("key1");
        set.add("key2");
        set.add("key3");
        set.add("key4");
        set.add("key5");
        set.add("key6");
        set.add("key7");
        set.add("key1");
        System.out.println(set);
    }

}
