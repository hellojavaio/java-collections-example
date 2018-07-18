package edu.maskleo.collections.map;

import java.util.IdentityHashMap;

public class IdentityHashMapExample {

    public static void main(String[] args) {
        IdentityHashMap<String, String> m = new IdentityHashMap<String, String>();
        m.put("K","V");
        m.put("K","V3");
        m.put(new String("K"),"V2");
        System.out.println(m);
    }

}
