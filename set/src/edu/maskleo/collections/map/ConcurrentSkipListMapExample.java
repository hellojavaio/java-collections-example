package edu.maskleo.collections.map;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListMapExample {

    public static void main(String[] args) {
        long startProdData = System.currentTimeMillis();
        int size = 100000;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long endProdData = System.currentTimeMillis();
        System.out.println("生成随机数耗时:" + (endProdData - startProdData));

        TreeSet<String> treeSet = new TreeSet();
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            treeSet.add(list.get(i));
        }

        long endBuildTree = System.currentTimeMillis();
        System.out.println("构建tree耗时:" + (endBuildTree - endProdData));


        PriorityQueue queue = new PriorityQueue();

        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            queue.add(list.get(i));
        }

        long endBuildQueue = System.currentTimeMillis();
        System.out.println("构建queue耗时:" + (endBuildQueue - endBuildTree));

        ConcurrentSkipListSet skipListSet = new ConcurrentSkipListSet();
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            skipListSet.add(list.get(i));
        }

        long endBuildSkip = System.currentTimeMillis();
        System.out.println("构建skip耗时:" + (endBuildSkip - endBuildQueue));

        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            treeSet.contains(list.get(i));
        }

        long endChecktree = System.currentTimeMillis();
        System.out.println("检索tree耗时:" + (endChecktree - endBuildSkip));

        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            skipListSet.contains(list.get(i));
        }

        long endCheckSkip = System.currentTimeMillis();
        System.out.println("检索Skip耗时:" + (endCheckSkip - endChecktree));

        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            queue.contains(list.get(i));
        }

        long endCheckQueue = System.currentTimeMillis();
        System.out.println("检索queue耗时:" + (endCheckQueue - endCheckSkip));
    }

}
