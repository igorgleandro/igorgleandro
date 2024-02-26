package io.codeforall.bootcamp.filhosdamain;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Client implements Runnable {

    private Socket clientSocket;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {
        try {
            //System.out.println(Thread.currentThread().getName());
            //System.out.println("🔌 Connection established\n");

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
                buffer = Files.readAllBytes(Paths.get(file.getPath()));
            }

            outputStream.write(responseHeader.getBytes());
            outputStream.write(buffer);

            in.close();
            outputStream.close();
            //clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




