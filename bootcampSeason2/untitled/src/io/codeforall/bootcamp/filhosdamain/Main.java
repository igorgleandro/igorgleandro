package io.codeforall.bootcamp.filhosdamain;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        InetAddress getByName;
        boolean isReachableChecker;

        getByName = InetAddress.getByName(getHost());
        isReachableChecker = getByName.isReachable(10000);
        System.out.println("The IP is " + getByName.getHostAddress() + ", reachable? " + isReachableChecker);
    }


    private static String getHost() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("Hostname? ");
        return reader.nextLine();
    }
}

