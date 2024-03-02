package io.codeforall.bootcamp.filhosdamain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Scanner;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL(getUrl().toLowerCase());
        URLConnection connection = url.openConnection();

        BufferedReader reader = new BufferedReader((new InputStreamReader((connection.getInputStream()))));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static String getUrl() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("🌎Set URL: ");
        return reader.nextLine();
    }
}
