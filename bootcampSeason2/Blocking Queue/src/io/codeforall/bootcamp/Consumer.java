package io.codeforall.bootcamp;

import io.codeforall.bootcamp.filhosdamain.BQueue;
import io.codeforall.bootcamp.filhosdamain.Pizza;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {

            while (elementNum > 0) {
                synchronized (this) {
                     if (queue.getSize() > 0) {
                    try {
                        Thread.sleep(1000);

                        queue.poll();
                        System.out.println(Thread.currentThread().getName()  + ": ate the Pizza 🍕");
                        elementNum--;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

              }
            }
        }
    }
}

