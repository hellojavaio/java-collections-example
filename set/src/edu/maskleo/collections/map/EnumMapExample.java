package edu.maskleo.collections.map;

import java.util.EnumMap;

public class EnumMapExample {

    enum Switch {
        ON,OFF
    }

    public static void main(String[] args) {
        EnumMap<Switch, String> enumMap = new EnumMap(Switch.class);
        enumMap.put(Switch.OFF, "1");
        enumMap.put(Switch.ON, "1");
        System.out.println(enumMap);
    }

}
