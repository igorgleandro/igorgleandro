package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;

public class Game {

    private String word;
    private LinkedList<Player> playerList;
    private int getCategoryMenu = (int)Math.floor(Math.random() * 2);
    private int numberOfPlayers;


    public Game(LinkedList<Player> playerList, int numberOfPlayers) {

        this.playerList = playerList;
        this.numberOfPlayers = numberOfPlayers;


//        while (getCategoryMenu == 0) {
//            for (int i = 0; i < playerList.size(); i++) {
//                playerList.get(i).getCategoryMenu();
//                System.out.println("playerList.get(i).getCategoryMenu()");
//
//            }
//        }
    }

    public void start() {

        if(playerList.get(0).hasChooseCat() && playerList.get(1).hasChooseCat()) {

        }
        

        /*Words pickedWord = new Words();


        try {
            //this.word = pickedWord.getWord(playerList.get(0).getCategoryMenu());
            System.out.println(" The word is " + word);

            ShuffleString shuffleString = new ShuffleString();
            String dyslexiaWord = ShuffleString.shuffleString(word);

            for (int i = 0; i < playerList.size(); i++) {


                System.out.println(" The word is " + dyslexiaWord);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        while (true) {


        }*/
    }
    public int getCategoryMenu( Socket clientSocket, Player player) throws IOException {

        Prompt prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        out.println("\n\n\n_________________________________\n--WELCOME TO <MY_DYSLEXIA>--\n_________________________________\n");

        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("\nPLEASE SET YOUR NAME:");
        String name = prompt.getUserInput(question1);
        Thread.currentThread().setName(name);
        out.println(name);

        int chooseId =  Prompts.menuDisplay(clientSocket);
        player.setHasChooseCat();
        start();
        return chooseId;
    }

//    public void checkOption() {
//            if(playerList.get(0).getChooseCategoryId() == playerList.get(1).getChooseCategoryId()) {
//                this.getCategoryMenu = playerList.get(0).getChooseCategoryId();
//            } else {
//                this.getCategoryMenu = (int)Math.floor(Math.random() * 2);
//            }
//        System.out.println("Category choose was " + getCategoryMenu);
//    }
}

