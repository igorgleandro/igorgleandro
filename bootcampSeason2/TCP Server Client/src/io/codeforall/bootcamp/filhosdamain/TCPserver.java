package io.codeforall.bootcamp.filhosdamain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPserver {

    public static void main(String[] args) throws IOException {

        // STEP1: Get parameters from command line arguments
        InetAddress hostName = InetAddress.getByName(getHost());
        int portNumber = Integer.parseInt(getPort());
        System.out.println("\n🌈Hostname: " + hostName + " and Portnumber: " + portNumber + " has been defined.");


        // STEP2: Bind to local port and block while waiting for client connections

        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("😴Waiting for client... ");
        Socket clientSocket = serverSocket.accept();
        System.out.println("🔌Connection established\n \n👂🏻Hello!, Waiting the first message from the client.");


// STEP3: Setup input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

// STEP4: Read from/write to the stream


        while (serverSocket.isBound() == true) {
            String msgReceived = in.readLine();
            System.out.println("📥Client said:" + msgReceived);
            String msgTobeSend = setMessage();
            out.println(msgTobeSend);
        }
// STEP5: Close the streams
        in.close();
        out.close();

// STEP6: Close the sockets
        serverSocket.close();

    }

    //STEP1:
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

