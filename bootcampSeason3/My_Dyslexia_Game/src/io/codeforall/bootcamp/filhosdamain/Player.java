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



    public Player(Socket clientSocket, Game game) {
        this.clientSocket = clientSocket;
        this.game = game;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            this.chooseCategoryId = game.getCategoryMenu(clientSocket, this);





            while (!clientSocket.isClosed()) {

            }
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
}

