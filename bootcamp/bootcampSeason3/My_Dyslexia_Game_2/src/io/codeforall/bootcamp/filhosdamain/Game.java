package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Objects;

public class Game implements Runnable {

    private String word;
    private LinkedList<Player> playerList;
    private int getCategoryMenu = (int) Math.floor(Math.random() * 2);
    private int numberOfPlayers;
    private int chooseCatMenu;
    private boolean usersReady;
    private boolean gameStart;
    private boolean isMenuChose;
    private boolean canGenerateWord = true;
    private String dyslexiaWord;
    private String message;


    private static boolean isInit = false;


    public Game(LinkedList<Player> playerList, int numberOfPlayers) {
        this.playerList = playerList;
        this.numberOfPlayers = numberOfPlayers;

    }

    public boolean isCanGenerateWord() {
        return canGenerateWord;
    }

    public void sendMessageToAll() throws IOException {

        for (Player player : playerList) {
            PrintWriter out = new PrintWriter(player.getClientSocket().getOutputStream(), true);
            out.println(message);
        }
    }

    public int getQuestion(Socket clientSocket, Player player) throws IOException {

        while (canGenerateWord) {


            Prompt prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));

            generateQuestion(clientSocket, player);

            StringInputScanner question1 = new StringInputScanner();
            question1.setMessage("");
            String guess = "a";
            sendMessageToAll();

            while (!guess.equals(word)) {
                guess = prompt.getUserInput(question1).toUpperCase();
                if (guess.equals(word)) {
                    setCanGenerateWord();
                    player.setPointsPlayer();
                    return 1;
                }
            }
        }

        return 0;
    }

    public int generateQuestion(Socket clientSocket, Player player) {

        if (canGenerateWord) {
            Words pickedWord = new Words();

            this.word = pickedWord.getWord(getCategoryMenu);

            System.out.println("The word to be guessed is: " + word);

            ShuffleString shuffleString = new ShuffleString();
            this.dyslexiaWord = ShuffleString.shuffleString(word);
            this.message = "\nOh Gosh, my dyslexia again... Help me: What word is this?\n" + "\u001B[32m" + dyslexiaWord.toUpperCase() + "\u001B[0m" + "\n";
            System.out.println(" The Dyslexia word is " + dyslexiaWord);
            canGenerateWord = true;
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

            switch (getCategoryMenu) {
                case 1:
                    return ("Both chose the Category:\n"+"\u001B[33m"+"Animal"+"\u001B[0m");
                case 2:
                    return ("Both chose the Category:\n"+"\u001B[33m"+"Movies"+"\u001B[0m");
                case 3:
                    return ("Both chose the Category:\n"+"\u001B[33m"+"IT Related"+"\u001B[0m");
            }
        } else {
            this.getCategoryMenu = (int) Math.ceil(Math.random() * 2);

            switch (getCategoryMenu) {
                case 1:
                    return ("None of you agreed with the same thing, so  I chose it for you, Category is:\n"+"\u001B[33m"+"Animal"+"\u001B[0m");
                case 2:
                    return ("None of you agreed with the same thing, so  I chose it for you, Category is:\n"+"\u001B[33m"+"Movies"+"\u001B[0m");
                case 3:
                    return ("None of you agreed with the same thing, so  I chose it for you, Category is:\n"+"\u001B[33m"+"IT Related"+"\u001B[0m");
            }


        }
        return "a";
    }

    public boolean isUsersReady() {
        return usersReady;
    }

    public void start() {
        while (!usersReady) {
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
            if (player.getName() == null) {
                ready = false;
            }
        }
        return ready;
    }

    public boolean startMatch() {
        isMenuChose = true;
        System.out.print("");
        for (Player player : playerList) {
            if (!player.hasChooseCat()) {
                isMenuChose = false;
            }
        }
        return isMenuChose;
    }

    public boolean isMenuChose() {
        return isMenuChose;
    }

    public void setCanGenerateWord() {
        canGenerateWord = true;
    }


    @Override
    public void run() {
        start();
    }

    public boolean isInit() {
        return isInit;
    }

    public void setInit() {
        isInit = true;
    }

    public void winner(Player winnerPlayer) throws IOException {
        for (Player player : playerList) {
            PrintWriter out = new PrintWriter(player.getClientSocket().getOutputStream(), true);
            out.println("\nCongratulations," + "\u001B[31m"+ winnerPlayer.getName().toUpperCase()+"\u001B[0m" + "! You're the champion of unscrambled chaos!\nYou've unlocked the ultimate achievement: Master of the Jumbled Jungle!\nBow down, folks, for " + "\u001B[31m"+ winnerPlayer.getName().toUpperCase()+"\u001B[0m" + " has emerged victorious from the wordy warzone!\n\n\n\nDone! Bye!");
            //"\u001B[33m"+"Animal"+"\u001B[0m");
        }
    }

    public void guessMessage(Player winnerPlayer) throws IOException {
        for (Player player : playerList) {
            PrintWriter out = new PrintWriter(player.getClientSocket().getOutputStream(), true);
            out.println("\n" + winnerPlayer.getName().toUpperCase() + " got it the word " +"\u001B[33m"+ word + "\u001B[0m"+"!!!");
            out.println(winnerPlayer.getName().toUpperCase() + " have " + winnerPlayer.getPointsPlayer());

        }
    }
}
