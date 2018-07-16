package edu.maskleo.collections.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class LinkedTransferQueueExample {
    public static void main(String[] args) {
        LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();
        new Thread(() -> {
                try {
                    Thread.sleep(500);  // 再改成1500
                    System.out.println(Thread.currentThread().getName()+"-"+queue.take());
                    System.out.println(Thread.currentThread().getName()+"-"+queue.take());
                    System.out.println(Thread.currentThread().getName()+"-"+queue.take());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
        },"consumer").start();
        new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"-"+queue.tryTransfer(1));
                try {
                    System.out.println(Thread.currentThread().getName()+"-等待2被消耗："+queue.tryTransfer(2, 1, TimeUnit.SECONDS));
                    queue.transfer(3);
                    System.out.println(Thread.currentThread().getName()+"-"+"等到3被消费：true");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        },"prodcuer").start();
    }
}
