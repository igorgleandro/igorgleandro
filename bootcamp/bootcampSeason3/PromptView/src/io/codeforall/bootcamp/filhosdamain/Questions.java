package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Questions {



    public void questions(){
    Prompt prompt = new Prompt(System.in, System.out);

    // create a question, and set the message to be displayed
    StringInputScanner question1 = new StringInputScanner();
    question1.setMessage("What is your name?");

    // create one more question
    IntegerInputScanner question2 = new IntegerInputScanner();
    question2.setMessage("What is your age?");

    // use the prompt to make the first question
    // this method will block the thread execution while waiting for user input
    String name = prompt.getUserInput(question1);

    // notice how the return type is defined by the scanner/question
    int age = prompt.getUserInput(question2);
    System.out.println("User's name: " + name + " | User's age: " + age);

}}
