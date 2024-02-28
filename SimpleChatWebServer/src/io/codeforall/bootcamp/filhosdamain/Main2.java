/*

package io.codeforall.bootcamp.filhosdamain;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class Launcher {

    public void main(String[] args) throws IOException {

        // LinkedList to store client sockets
        LinkedList<Socket> clientSocketKey = new LinkedList<>();

        // Get hostname and port number from user
        InetAddress hostName = InetAddress.getByName(getHost());
        int portNumber = Integer.parseInt(getPort());
        System.out.println("\n🌈Hostname: " + hostName + " and Portnumber: " + portNumber + " has been defined.");

        // Create a ServerSocket bound to the specified port
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("😴Waiting for client... ");

        // Accept and handle client connections
        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSocketKey.add(clientSocket);

            System.out.println("🔌Connection established\n \n👂🏻Hello!, Waiting the first message from the client.");

            // Create a new thread to handle communication with the client
            Thread newClient = new Thread(new Client(clientSocket, this));
            newClient.start();
        }
    }

    // Prompt user to enter the host
    private static String getHost() throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.print("🏨Enter Host: ");
        return reader.nextLine();
    }

    // Prompt user to enter the port number
    private static String getPort() {
        Scanner reader = new Scanner(System.in);
        System.out.print("🚪Enter PortNumber: ");
        return reader.nextLine();
    }

    // Method to send a message to all connected clients
    void sendTextAll(String string) {
        for (int i = 0; i < clientSocketKey.size(); i++) {
            try {
                // Get the output stream of each client socket and send the message
                PrintWriter outAll = new PrintWriter(clientSocketKey.get(i).getOutputStream(), true);
                outAll.println(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}*/
