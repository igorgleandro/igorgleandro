package io.codeforall.bootcamp;

import io.codeforall.bootcamp.filhosdamain.BQueue;
import io.codeforall.bootcamp.filhosdamain.Pizza;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Pizza> queue;
    private int elementNum;

    /**
     * @param queue      the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
    }

    @Override
    public void run() {
        while (elementNum > 0) {
           synchronized (this) {
               if (queue.getSize() < queue.getLimit()) {
                    try {
                        Thread.sleep(1000);

                        queue.offer(new Pizza());
                        System.out.println("👨🏻‍🍳" + Thread.currentThread().getName() + ": made a Pizza 🍕");
                        elementNum--;

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }
}
