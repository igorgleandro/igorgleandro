package io.codeforall.bootcamp.filhosdamain;

public class Tree extends GameObject{

    @Override
    public String getMessage(){
        String treeMessage = "I'm a Tree!!";
        return treeMessage;
    }

    @Override
    public String toString() {
        return "Tree";
    }
}
