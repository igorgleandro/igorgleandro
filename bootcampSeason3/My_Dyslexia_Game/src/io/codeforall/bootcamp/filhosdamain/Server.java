package io.codeforall.bootcamp.filhosdamain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Server {

    public static void main(String[] args) {


        LinkedList<ClientConnection> users = new LinkedList<>();
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            ExecutorService cachedPool = Executors.newCachedThreadPool();

            while (true) {
                ClientConnection connection = new ClientConnection(serverSocket.accept(), serverSocket, users);
                users.add(connection);
                if(users.size() == 2) {
                    cachedPool.submit(connection);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }

}
