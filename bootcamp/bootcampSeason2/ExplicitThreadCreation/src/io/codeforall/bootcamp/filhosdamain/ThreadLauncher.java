package io.codeforall.bootcamp.filhosdamain;

public class ThreadLauncher {
    public static void main(String[] args) {

       MyRunnableTask myRunnableTask = new MyRunnableTask();
       myRunnableTask.run();


        for(int i = 0 ; i <10; i++){
            Thread thread = new Thread(new MyRunnableTask());
            thread.setName("Sweet Thread number: " + i);
            thread.start();
        }

        Thread myTask = new Thread(myRunnableTask);
        myTask.start();

    }
}
