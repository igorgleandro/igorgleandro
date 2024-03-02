package io.codeforall.bootcamp.filhosdamain;

public class Room {

    private int key;
    private boolean available;

    public Room (int key){ //Metodo Room recebe variavel Key
        this.key = key; // atribuiu a variavel key em room o argumento da key recebido
    }

    public void changeStatus(){ // metodo changeStatus
        available = !available; // iverte true falso da variavel available
    }

    public int getKey() { // metodo getKey
        return key; // return the key number
    }

    public boolean isAvailable() { // methodo isAvailable
        return available; // return status do available ( true or false)
    }
}
