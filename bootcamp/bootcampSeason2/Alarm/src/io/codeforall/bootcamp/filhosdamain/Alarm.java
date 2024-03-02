package io.codeforall.bootcamp.filhosdamain;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many times to ring");
        int rings = Integer.parseInt(scanner.next());

        System.out.println("Ring Interval in seconds");
        int interval = Integer.parseInt(scanner.next());

        Alarm alarm = new Alarm();
        Alarm alarm2 = new Alarm();

        alarm.start(rings, interval);
        alarm2.start(rings,interval);

    }

    public void start(int rings, int interval) {
        System.out.println(Thread.currentThread().getName());
        timer = new Timer();
        timer.scheduleAtFixedRate(new Ring(rings),interval*1000,interval*1000);

    }

    private class Ring extends TimerTask {

        private int rings;
        public Ring(int rings) {
            this.rings = rings;
        }

        @Override
        public void run() {
            System.out.println("alarm is ringing");
            System.out.println(Thread.currentThread().getName());
            rings--;
            if(rings == 0){
                System.out.println("alarm has stopped");
                stop();
            }

        }
        private void stop(){
            timer.cancel();
        }
    }
}
