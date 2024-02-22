package io.codeforall.bootcamp.filhosdamain;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main2 {

        public static void main(String[] args) {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("😴 Waiting for client...");
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

                } else if (path.equals("\\.")){
                    path = "/potato.jpeg";
                } else{
                    path = "/404.html";
                }

                File file = new File("resources" + path);
                String responseHeader;
                byte[] buffer;

                if (file.exists() && path.contains("/index")) {
                    responseHeader = "HTTP/1.0 200 OK\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length:" + file.length() + "\r\n\r\n";
                    buffer = Files.readAllBytes(Paths.get(file.getPath()));

                } if (file.exists() && path.contains("/potato")) {
                    responseHeader = "HTTP/1.0 200 Document Follows\r\n" +
                    "Content-Type: image/jpg \r\n" +
                    "Content-Length:" + file.length() + "\r\n\r\n";
                    buffer = Files.readAllBytes(Paths.get(file.getPath()));
                }
                else {
                    responseHeader = "HTTP/1.0 404 Not Found\r\n" +
                    "Content-Type: text/html; charset=UTF-8\r\n" +
                    "Content-Length:" + file.length() + "\r\n\r\n";
                    buffer = Files.readAllBytes(Paths.get(file.getPath()));
                }

                outputStream.write(responseHeader.getBytes());
                outputStream.write(buffer);

                in.close();
                outputStream.close();
                clientSocket.close();
                serverSocket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}
