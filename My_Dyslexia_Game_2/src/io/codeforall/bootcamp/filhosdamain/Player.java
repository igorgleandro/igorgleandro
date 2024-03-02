package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;

public class Player implements Runnable {

    private Socket clientSocket;
    private int chooseCategoryId = 10;
    private Game game;
    private boolean hasChoseCat;
    private Prompt prompt;
    PrintWriter selfOut;



    private int pointsPlayer;


    private String name;

    public Player(Socket clientSocket, Game game) throws IOException {
        this.clientSocket = clientSocket;
        this.game = game;
        this.prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
        try {
            this.selfOut = new PrintWriter(clientSocket.getOutputStream(), true);
            selfOut.println("""
                    
                      __  __         _____            _           _      \s
                     |  \\/  |       |  __ \\          | |         (_)     \s
                     | \\  / |_   _  | |  | |_   _ ___| | _____  ___  __ _\s
                     | |\\/| | | | | | |  | | | | / __| |/ _ \\ \\/ / |/ _` |
                     | |  | | |_| | | |__| | |_| \\__ \\ |  __/>  <| | (_| |
                     |_|  |_|\\__, | |_____/ \\__, |___/_|\\___/_/\\_\\_|\\__,_|
                              __/ |          __/ |                       \s
                             |___/          |___/                        \s
                    
                    """);
            selfOut.println("_________________________________\n----WECOllME TO <MY_DSYLEXIA>----\n_________________________________\n\n" + "\u001B[33m" +"\"Hey folks, gather 'round, my Dyslexia is throwing a wild party in my brain lately... \nSo, lend me a hand unjumbling these words, would ya? Here's the deal:\nWhoever unscrambles 5 words first gets to claim victory and eternal glory!\n" + "\u001B[0m");
            selfOut.println( "\u001B[32m" +"please wait all players..." + "\u001B[0m");

        } catch (Exception e) {

        }
    }
    @Override
    public void run() {
        try {
            start();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.chooseCategoryId = game.getCategoryMenu(clientSocket, this);

            while (!game.isMenuChose()) {
                game.startMatch();
                }
            out.println(game.checkOption());


            while (pointsPlayer < 5) {
                System.out.println(pointsPlayer + name);

                if(!game.isInit()) {
                    game.getQuestion(clientSocket, this);

                } else{
                        game.getQuestion(clientSocket, this);
                        game.setInit();

                }
            }

            game.winner(this);
            System.exit(1);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public int getChooseCategoryId() {
        return chooseCategoryId;
    }

    public void setChooseCategoryId(int catId) {
        this.chooseCategoryId = catId;
    }

    public void setHasChooseCat() {
        this.hasChoseCat = true;
    }

    public boolean hasChooseCat() { return hasChoseCat;}

    public String getName() {

        return name;
    }

    public boolean joined() {
        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("\nWho the hell are you??\n");

        name = prompt.getUserInput(question1);
        selfOut.println("\nWoohoo! Give it up for the one and only " + name+ "!");

        return true;

    }

    public void start() {
        while (true) {
            System.out.print("");
            if (game.isUsersReady()) {
                if (joined()) {
                    selfOut.println("Waiting for all player to connect... Be ready to play at any moment");
                    break;
                }
            }
        }

        while (!game.isGameStart()) {
            if (game.verifyAllPlayersJoined()) {
                game.setGameStart();
            }
        }
        selfOut.println("All playing");
    }

    public void setPointsPlayer() throws IOException {
        this.pointsPlayer++;
        game.guessMessage(this);
    }

    public int getPointsPlayer() {
        return pointsPlayer;
    }
}

