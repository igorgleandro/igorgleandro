package io.codeforall.bootcamp.filhosdamain;

import javax.swing.text.html.HTML;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import static java.io.File.*;

public class Main {

    public static void main(String[] args) throws IOException {

        try {




            // STEP1: Get parameters from command line arguments
            //InetAddress hostName = InetAddress.getByName(getHost());
            //int portNumber = Integer.parseInt(getPort());
            //System.out.println("\n🌈 and Portnumber: " + portNumber + " has been defined.");


            // STEP2: Bind to local port and block while waiting for client connections

            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("😴Waiting for client... ");
            Socket clientSocket = serverSocket.accept();
            System.out.println("🔌Connection established\n \n👂🏻Hello!, Waiting the first message from the client.");


            // STEP3: Setup input and output streams
            //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            OutputStream outputStream = clientSocket.getOutputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            // STEP4: Read from/write to the stream


            //while (serverSocket.isBound()) {

                String msgReceived = in.readLine();
                String[] parts = msgReceived.split(" ");
                String path = parts[1];
                System.out.println("📥Client said:" + msgReceived);

                if (path.equals("/")) {
                    path = "/index.html";
                }
                if (path.equals("/potato.jpg")) {
                    path = "/potato.jpg";
                } else {
                    path = "/404.html";
                }


                File file = new File("resources/index.html");
                FileInputStream fileStream = new FileInputStream(file);
                fileStream.readAllBytes();

                String responseHeader = "HTTP/1.0 200 Document Follows\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length:"+file.length()+"\r\n\r\n";

            //byte[] buffer = Files.readAllBytes(Paths.get("resources" + path));
            byte[] buffer = fileStream.readAllBytes();
                System.out.println(Arrays.toString(responseHeader.getBytes()));
                outputStream.write(responseHeader.getBytes());
                outputStream.write(buffer);
            //}
// STEP5: Close the streams
            in.close();
            outputStream.close();

// STEP6: Close the sockets
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}