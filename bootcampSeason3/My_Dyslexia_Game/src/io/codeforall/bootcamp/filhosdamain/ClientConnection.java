package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Executors;

public class ClientConnection implements Runnable {
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private LinkedList<ClientConnection> users;
    private String name;
    final String ANSI_RESET = "\u001B[0m";
    PrintWriter selfOut;

    public ClientConnection(Socket clientSocket, ServerSocket serverSocket, LinkedList<ClientConnection> users) {
        this.clientSocket = clientSocket;
        this.serverSocket = serverSocket;
        this.users = users;
        try {
            this.selfOut = new PrintWriter(clientSocket.getOutputStream(), true);
            selfOut.println("Welcome to ChatRoom (use /help to see options)");
        } catch (Exception e) {

        }
    }


    public void joined() {
        try {
            for (int i = 0; i < users.size(); i++) {
                PrintWriter out = new PrintWriter(users.get(i).clientSocket.getOutputStream(), true);
                out.println(Thread.currentThread().getName() + " joined the chat.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void sendMessageToAll(String message) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (!users.get(i).equals(this)) {
                    PrintWriter out = new PrintWriter(users.get(i).clientSocket.getOutputStream(), true);
                    out.println(message);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sendDmMessage(String receiver, String message) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (Objects.equals(users.get(i).name, receiver)) {
                    PrintWriter out = new PrintWriter(users.get(i).clientSocket.getOutputStream(), true);
                    out.println(this.name + " sent directly to you the following message: " + message);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void banUser(String target) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (Objects.equals(users.get(i).name, target)) {
                    PrintWriter out = new PrintWriter(users.get(i).clientSocket.getOutputStream(), true);
                    out.println("You have been banned! What have you done?? Don't tell me your innocent!");
                    users.remove(i);
                    out.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        joined();

        Prompt prompt = null;
        try {
            prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        out.println("\n\n\n_________________________________\n--WELCOME TO <MY_DYSLEXIA>--\n_________________________________\n");

        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("\nPLEASE SET YOUR NAME:");
        String name = prompt.getUserInput(question1);
        Thread.currentThread().setName(name);
        out.println(name);


            Prompts.menuDisplay(clientSocket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

