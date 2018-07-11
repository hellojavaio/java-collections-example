package edu.maskleo.collections.set;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

public class CopyOnWriteArraySetExample {

    public static void main(String[] args) {
        for (int k = 0; k < 10; k++) {
            int size = 10000;
            // 这里如果换成 ArrayList 结果就可能不对了
            List<String> list = new CopyOnWriteArrayList<>();
            CountDownLatch begin = new CountDownLatch(1);
            CountDownLatch count = new CountDownLatch(size);
            for (int i = 0; i < size; i++) {
                Runnable runnable = new ThreadDemo(list, begin, count);
                new Thread(runnable, "thread - " + i).start();
            }
            begin.countDown();
            try {
                count.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(list.size());
        }
    }

    static class ThreadDemo implements Runnable {
        final List<String> list;
        final CountDownLatch begin;
        final CountDownLatch threadCount;

        public ThreadDemo(List<String> list, CountDownLatch begin, CountDownLatch threadCount) {
            this.list = list;
            this.begin = begin;
            this.threadCount = threadCount;
        }

        @Override
        public void run() {
            try {
                begin.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(UUID.randomUUID().toString());
            threadCount.countDown();
        }
    }

}
