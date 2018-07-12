package edu.maskleo.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue();
        queue.add(15);
        queue.add(1);
        queue.add(6);
        queue.add(0);
        queue.add(15);
        queue.add(1);
        // [0, 1, 0, 15, 15, 6]
        System.out.println(queue);
    }

}
