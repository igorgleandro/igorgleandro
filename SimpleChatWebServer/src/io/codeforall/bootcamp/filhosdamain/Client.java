package io.codeforall.bootcamp.filhosdamain;

import javax.naming.NamingEnumeration;
import java.io.*;

import java.net.Socket;

import java.util.Scanner;

public class Client implements Runnable {

    private Socket clientSocket;
    String msngReceived;
    Launcher launcher;

    public Client(Socket clientSocket, Launcher launcher) {
        this.clientSocket = clientSocket;
        this.launcher = launcher;


    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("\n\n\n_________________________________\n--WELCOME TO THE iGOR_Messages!--\n_________________________________\n");
            out.println("--COMMANDS LINE-- \n-/name : CHANGES YOUR NAME\n-/quit : QUIT THE CHAT\n--ENJOY :D--\n\n");

            while (!clientSocket.isClosed()) {
                String quitCommand = "/quit";
                String nameCommand = "/name";


                String msgReceived = in.readLine();
                System.out.println("📥" + Thread.currentThread().getName().toUpperCase() + " said:" + msgReceived);
                String msgTobeSend = msgReceived;

                if (msgReceived.equals(nameCommand)) {
                    out.println("\nPLEASE SET YOUR NAME: ");
                    String newName = in.readLine();
                    String oldName = Thread.currentThread().getName();
                    Thread.currentThread().setName(newName);
                    out.println("YOUR NICKNAME IS: " + newName + "\n");
                    launcher.sendTextAll(oldName.toUpperCase() + " changed his name to: " + newName.toUpperCase() + "\n");

                } else if (msgReceived.equals(quitCommand)) {
                    launcher.sendTextAll(Thread.currentThread().getName().toUpperCase() + " left the chat.");
                    in.close();
                    out.close();
                    clientSocket.close();
                } else {
                    launcher.sendTextAll(Thread.currentThread().getName().toUpperCase() + " said: " + msgTobeSend);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




