package io.codeforall.bootcamp.filhosdamain;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TodoList {

    int priority;
    String item;
    Importance importance;

    PriorityQueue<Task> pq = new PriorityQueue<>();


    public boolean add(Importance importance, int priority, String item) {
        return pq.add(new Task(importance, priority, item));


    }

    public void getItems() {
        for (Task task : this.pq) {
            System.out.println(task.item);
        }
    }

    public enum Importance {
        LOW,
        MEDIUM,
        HIGH,
    }

    public Task remove() {
        return pq.poll() ;

    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }


    public class Task implements Comparable<Task> {

        private int priority;
        private String item;
        private Importance importance;

        public Task(Importance importance, int priority, String item) {
            this.priority = priority;
            this.item = item;
            this.importance = importance;
        }

        @Override
        public int compareTo(Task o) {
            if (this.importance.compareTo(o.importance) == 0) {
                return this.priority - o.priority;
            }
            return this.importance.compareTo(o.importance);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", item='" + item + '\'' +
                    ", importance=" + importance +
                    '}';
        }
    }
}
