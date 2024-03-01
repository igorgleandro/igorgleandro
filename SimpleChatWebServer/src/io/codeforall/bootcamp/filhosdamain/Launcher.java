package io.codeforall.bootcamp.filhosdamain;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class Launcher {

    private static LinkedList<Socket> clientSocketKey;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            clientSocketKey = new LinkedList<>();

            InetAddress hostName = InetAddress.getByName(getHost());
            int portNumber = Integer.parseInt(getPort());
            System.out.println("\n🌈Hostname: " + hostName + " and Portnumber: " + portNumber + " has been defined.");


            serverSocket = new ServerSocket(portNumber);
            System.out.println("😴Waiting for client... ");

            Launcher launcher = new Launcher();
            launcher.connexionListening();
        } catch (Exception e) {
        }
    }


    private static String getHost() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("🏨Enter Host: ");
        return reader.nextLine();
    }

    private static String getPort() {

        Scanner reader = new Scanner(System.in);
        System.out.print("🚪Enter PortNumber: ");
        return reader.nextLine();
    }

    //Broadcast method to send sms to all
    void sendTextAll(String string) {


        for (int i = 0; i < clientSocketKey.size(); i++) {
            try {
                PrintWriter outAll = new PrintWriter(clientSocketKey.get(i).getOutputStream(), true);
                outAll.println(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void connexionListening() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSocketKey.add(clientSocket);

            System.out.println("🔌Connection established\n \n👂🏻Hello!, Waiting the first message from the client.");

            Thread newClient = new Thread(new Client(clientSocket, this));
            newClient.start();


        }
    }
}
