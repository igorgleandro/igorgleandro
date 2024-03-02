package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;

public class Player implements Runnable {

    private Socket clientSocket;
    private int chooseCategoryId = 10;
    private Game game;
    private boolean hasChooseCat;
    private Prompt prompt;
    PrintWriter selfOut;


    private String name;

    public Player(Socket clientSocket, Game game) throws IOException {
        this.clientSocket = clientSocket;
        this.game = game;
        this.prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
        try {
            this.selfOut = new PrintWriter(clientSocket.getOutputStream(), true);
            selfOut.println("\n\n\n_________________________________\n--WELCOME TO <MY_DYSLEXIA>--\n_________________________________\n");
        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
        try {
            start();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.chooseCategoryId = game.getCategoryMenu(clientSocket, this);

            out.println(game.checkOption());

            int points = 0;
            while (points < 5) {
                points = points + game.getQuestion(clientSocket, this);
                String name = Thread.currentThread().getName();
            }

            out.println("Congrats " + name + " You Won!");

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
        this.hasChooseCat = true;
    }

    public boolean hasChooseCat() {
        return hasChooseCat;
    }

    public String getName() {

        return name;
    }

    public boolean joined() {
        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("\nPLEASE SET YOUR NAME:");

        name = prompt.getUserInput(question1);
        selfOut.println("Wecollme " + name + "!");

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
}

