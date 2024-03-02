package io.codeforall.bootcamp.filhosdamain;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPclient {

    public static void main(String[] args) throws IOException {

        InetAddress hostNumber = setHost();
        int portNumber = Integer.parseInt(setPort());

        while (true) {
            try {
                byte[] sendBuffer = setMessage();

                DatagramSocket socket = new DatagramSocket();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, hostNumber, portNumber);
                socket.send(sendPacket);

                byte[] recvBuffer = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

                System.out.println("\n 📥 Waiting the Message...");

                socket.receive(receivePacket);
                String s = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
                System.out.println(" 📟UDPclient said: " + s);

                socket.close();


            } catch (IOException e) {

            }
        }
    }


    private static InetAddress setHost() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("🏨Enter Host: ");
        return InetAddress.getByName(reader.nextLine());
    }

    private static String setPort() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("🚪Enter PortNumber: ");
        return reader.nextLine();
    }

    private static byte[] setMessage() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("💬Set Text: ");
        return reader.nextLine().getBytes(StandardCharsets.UTF_8);
    }

//    public static void receiver(){
//
//
//        System.out.println("\n 📥 Waiting the Message...\n");
//
//            try {
//
//                byte[] recvBuffer = new byte[1024];
//
//                DatagramSocket socket = new DatagramSocket(8989);
//                DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
//                socket.receive(receivePacket);
//
//                String s = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
//                System.out.println(" 📟UDPserver said: " + s.toUpperCase());
//
//                socket.close();
//
//
//            } catch (IOException e) {
//            }
//        }
}