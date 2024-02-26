package io.codeforall.bootcamp.filhosdamain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private final int limit;
    private LinkedList<T> buffer = new LinkedList<>();

    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {
        this.limit = limit;
    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) throws InterruptedException {
        if (buffer.size() == limit) {
            System.out.println("Do I have to do a Pizza?");
            wait();
        }

        buffer.add(data);
        notifyAll();
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized T poll() throws InterruptedException {
        if (buffer.isEmpty()) {
            System.out.println("Do I have to wait for a Pizza?");
            wait();
        }
        notifyAll();
        return buffer.poll();

    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {
        return buffer.size();
    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;
    }


}
