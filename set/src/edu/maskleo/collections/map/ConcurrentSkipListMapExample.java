package edu.maskleo.collections.map;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapExample {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, Integer> cslm = new ConcurrentSkipListMap();
        java.util.Random random = new Random();
        for (int i = 0; i < 100; i++) {
            cslm.put(i, i);
        }
    }

}
