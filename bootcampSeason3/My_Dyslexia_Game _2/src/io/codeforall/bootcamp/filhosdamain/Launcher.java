package io.codeforall.bootcamp.filhosdamain;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Launcher {


    private static ServerSocket serverSocket;
    private static int numberOfPlayers;


    public static void main(String[] args) {
        //numberOfPlayers = Integer.parseInt(args[0]);
        numberOfPlayers = 2;
        try {
            serverSocket = new ServerSocket(9090);
            System.out.println("😴Waiting for client... ");
            Launcher launcher = new Launcher();
            launcher.connexionListening();

        } catch (Exception e) {
        }
    }

    public void connexionListening() throws IOException {
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        LinkedList<Player> playerList = new LinkedList<>();

        Game game = new Game(playerList, numberOfPlayers);
        cachedPool.submit(game);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("🔌Connection established\n");


            Player newPlayer = new Player(clientSocket,game);
            playerList.add(newPlayer);

            cachedPool.submit(newPlayer);

        }
    }
}
