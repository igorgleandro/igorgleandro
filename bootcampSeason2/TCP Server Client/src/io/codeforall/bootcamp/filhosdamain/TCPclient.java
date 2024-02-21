package io.codeforall.bootcamp.filhosdamain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPclient {
    public static void main(String[] args) throws IOException {


        // STEP1: Get the host and the port from the command-line
        InetAddress hostName = InetAddress.getByName(getHost());
        int portNumber = Integer.parseInt(getPort());
        System.out.println("\n🌈Hostname: " + hostName + " and Portnumber: " + portNumber + " has been defined.");

        // STEP2: Open a client socket, blocking while connecting to the server
        Socket clientSocket = new Socket(hostName, portNumber);
        System.out.println("🔌Connection established\n\n👋🏻Hello server!\"");


        // STEP3: Setup input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


// STEP4: Read from/write to the stream
        while(clientSocket.isClosed() != true){
            out.println(setMessage());
            String msgReceived = in.readLine();
            System.out.println("📥Server said:" + msgReceived);
        }


// STEP5: Close the streams
        in.close();
        out.close();
// STEP6: Close the sockets
        clientSocket.close();
    }

//STEP1

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

    private static String setMessage() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("💬Set Text: ");
        return reader.nextLine();
    }
}

