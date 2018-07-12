package edu.maskleo.collections.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

    public static void main(String[] args) {
        DelayQueue<StrDelay> delayQueue = new DelayQueue();
        delayQueue.put(new StrDelay(1, 2000));
        delayQueue.put(new StrDelay(5, 4000));
        delayQueue.put(new StrDelay(4, 8000));
        delayQueue.put(new StrDelay(2, 16000));
        delayQueue.put(new StrDelay(1, 32000));
        System.out.println(delayQueue);
        for (; ; ) {
            try {
                StrDelay s = delayQueue.take();
                System.out.println(s);
                if (delayQueue.size() == 0) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    static class StrDelay implements Delayed {

        private Integer i;

        private long unit;

        public StrDelay(Integer i, long unit) {
            this.i = i;
            this.unit = unit + System.currentTimeMillis();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return this.unit - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            StrDelay target = (StrDelay) o;
            return (int) (this.unit - target.unit);
        }

        @Override
        public String toString() {
            return "StrDelay{" +
                    "i=" + i +
                    ", unit=" + unit +
                    '}';
        }
    }

}
