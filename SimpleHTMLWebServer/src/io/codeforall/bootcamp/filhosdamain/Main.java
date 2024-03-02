package io.codeforall.bootcamp.filhosdamain;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        try {

            InetAddress hostName = InetAddress.getByName(getHost());
            int portNumber = Integer.parseInt(getPort());
            System.out.println("\n🌈Hostname: " + hostName + " and Portnumber: " + portNumber + " has been defined.");


            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("😴 Waiting for client...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread newClient = new Thread( new Client(clientSocket));
                newClient.start();

            }

        } catch (IOException e){

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
}
