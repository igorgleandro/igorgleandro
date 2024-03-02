package io.codeforall.bootcamp.filhosdamain;

public class Main {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.add(TodoList.Importance.MEDIUM, 1, "Comer");
        todoList.add(TodoList.Importance.LOW, 1, "Beber");
        todoList.add(TodoList.Importance.HIGH, 1, "Dormir");
        todoList.add(TodoList.Importance.MEDIUM, 2, "AHOOOAAA");
        todoList.add(TodoList.Importance.LOW, 2, "Trabalhar");
        todoList.add(TodoList.Importance.HIGH, 2, "Foder");
        todoList.add(TodoList.Importance.MEDIUM,3,"Andar de Bicicleta");


        //todoList.getItems();

        while (!todoList.isEmpty()) {
            System.out.println(todoList.remove());
        }


    }
}
