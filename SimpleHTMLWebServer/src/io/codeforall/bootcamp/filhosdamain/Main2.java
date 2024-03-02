package io.codeforall.bootcamp.filhosdamain;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main2 {

    public static void main(String[] args){



        try {

            InetAddress hostName = InetAddress.getByName(getHost());
            int portNumber = Integer.parseInt(getPort());
            System.out.println("\n🌈Hostname: " + hostName + " and Portnumber: " + portNumber + " has been defined.");


            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("😴 Waiting for client...");


            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("🔌 Connection established\n");

                OutputStream outputStream = clientSocket.getOutputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String requestLine = in.readLine();
                System.out.println("📥 Client said: " + requestLine);

                String[] parts = requestLine.split(" ");
                String path = parts[1];

                if (path.equals("/")) {
                    path = "/index.html";
                } else if (path.equals("/potato")) {
                    path = "/potato.jpeg";
                } else if (path.equals(null)) {
                    path = "/potato.jpeg";
                } else {
                    path = "/404.html";
                }

                File file = new File("resources" + path);
                String responseHeader;
                byte[] buffer;

                if (file.exists() && path.contains("/index.html")) {
                    responseHeader = "HTTP/1.0 200 OK\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length:" + file.length() + "\r\n\r\n";
                    buffer = Files.readAllBytes(Paths.get(file.getPath()));

                } else if (file.exists() && path.contains("/potato")) {
                    responseHeader = "HTTP/1.0 200 Document Follows\r\n" +
                            "Content-Type: image/jpeg \r\n" +
                            "Content-Length:" + file.length() + "\r\n\r\n";
                    buffer = Files.readAllBytes(Paths.get(file.getPath()));
                } else {
                    responseHeader = "HTTP/1.0 404 Not Found\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length:" + file.length() + "\r\n\r\n";
                    buffer = path.getBytes(); // Using path instead of file content for 404 response
                }

                outputStream.write(responseHeader.getBytes());
                outputStream.write(buffer);

                // Close resources for this request
                in.close();
                outputStream.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
