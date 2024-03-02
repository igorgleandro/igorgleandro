package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class Prompts {

    public static int menuDisplay(Socket clientSocket) throws IOException {

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Prompt prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));

        String[] options = {"Animal", "Movies", "IT Related"};

        MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("Which category do you want to play?");
        scanner.setError("The dyslexia has began... Try again!");

        //out.println(scanner);

        int answerIndex = prompt.getUserInput(scanner);

        out.println("You selected " + options[answerIndex - 1]);

        return answerIndex;
    }
}
