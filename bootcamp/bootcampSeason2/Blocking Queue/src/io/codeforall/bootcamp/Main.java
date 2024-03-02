package io.codeforall.bootcamp;

import io.codeforall.bootcamp.filhosdamain.BQueue;
import io.codeforall.bootcamp.filhosdamain.Pizza;

public class Main {

    public static void main(String[] args) {

        BQueue<Pizza> queue= new BQueue<>(5);

        Producer p1 = new Producer(queue,10);
        Thread t1 = new Thread(p1);
        t1.setName("Luigi");

        Producer p2 = new Producer(queue,10);
        Thread t2 = new Thread(p2);
        t2.setName("Mario");

        Consumer c1 = new Consumer(queue, 10);
        Thread t3 = new Thread(c1);
        t3.setName("🍑️Peach");

        Consumer c2 = new Consumer(queue, 10);
        Thread t4 = new Thread(c2);
        t4.setName("🐲Bowser");

        t3.start();
        t4.start();

        t1.start();
        t2.start();

    }

}
