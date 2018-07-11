package edu.maskleo.collections.set;

import java.util.EnumSet;

public class EnumSetExample {

    enum Switch {
        ON,OFF
    }

    public static void main(String[] args) {
        EnumSet<Switch> enumSet = EnumSet.allOf(Switch.class);
        System.out.println(enumSet);
        System.out.println(EnumSet.complementOf(enumSet));
    }

}
