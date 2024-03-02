package io.codeforall.bootcamp.filhosdamain;

public class MyRunnableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("The tread running this task is: " + Thread.currentThread().getName());
    }
}
