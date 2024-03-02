package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Objects;

public class Game implements Runnable{

    private String word;
    private LinkedList<Player> playerList;
    private int getCategoryMenu = (int) Math.floor(Math.random() * 2);
    private int numberOfPlayers;
    private int chooseCatMenu;
    private boolean usersReady;
    private boolean gameStart;


    public Game(LinkedList<Player> playerList, int numberOfPlayers) {
        this.playerList = playerList;
        this.numberOfPlayers = numberOfPlayers;

    }

    public int getQuestion(Socket clientSocket, Player player) {

        Words pickedWord = new Words();
        try {
            Prompt prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            this.word = pickedWord.getWord(getCategoryMenu);
            System.out.println("The word to be guessed is: " + word);
            ShuffleString shuffleString = new ShuffleString();
            String dyslexiaWord = ShuffleString.shuffleString(word);

            //for (int i = 0; i < playerList.size(); i++) {
                StringInputScanner question1 = new StringInputScanner();
                question1.setMessage("\nOh Gosh, my dyslexia again... Help me: What word is this? " + dyslexiaWord.toUpperCase() + "\n");
                String guess = "a";

                while (!guess.equals(word)) {
                    guess = prompt.getUserInput(question1).toUpperCase();
                    if (guess.equals(word)) {
                        return 1;
                    }
                }

                System.out.println(" The word is " + dyslexiaWord);
            //}


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public int getCategoryMenu(Socket clientSocket, Player player) throws IOException {

        int chooseId = Prompts.menuDisplay(clientSocket);
        player.setHasChooseCat();
        return chooseId;
    }

    public String checkOption() {
        if (playerList.get(0).getChooseCategoryId() == playerList.get(1).getChooseCategoryId()) {
            this.getCategoryMenu = playerList.get(0).getChooseCategoryId();
            int agree = playerList.get(0).getChooseCategoryId();
            return ("Looks like both  of you chose the same: " + agree).toUpperCase();
        } else {
            this.getCategoryMenu = (int) Math.ceil(Math.random() * 2);
            return ("None of you agreed with the same thing, so  I chose it for you, Category is: number " + getCategoryMenu).toUpperCase();
        }


    }

    public boolean isUsersReady() {
        return usersReady;
    }

    public void start() {
        while(!usersReady) {
            System.out.print("");
            if (playerList.size() == 2) {
                this.usersReady = true;
                System.out.println("All players joined");
            }
        }

    }
    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart() {
        this.gameStart = true;
    }

    public boolean verifyAllPlayersJoined() {
        //System.out.println("AQUI");
        boolean ready = true;
        for (Player player : playerList) {
            if(player.getName() == null) {
                ready = false;
            }
        }
        return ready;
    }

    public boolean startMatch() {
        while(!usersReady) {
            System.out.print("");
            if (playerList.size() == 2) {
                this.usersReady = true;
                System.out.println("All players joined");
            }
        }
    }

    @Override
    public void run() {
        start();
    }


}
