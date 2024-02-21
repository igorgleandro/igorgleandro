package io.codeforall.bootcamp.filhosdamain;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class UDPserver {

    public static void main(String[] args) throws IOException {

        String msngReceived;

        InetAddress hostName = getHost();
        int portNumber = Integer.parseInt(getPort());

        while (true) {

            try {
                byte[] recvBuffer = new byte[1024];

                DatagramSocket socket = new DatagramSocket(portNumber);
                DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);

                System.out.println("\n 📥 Waiting the Message...");

                socket.receive(receivePacket);

                String s = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
                System.out.println(" 📟UDPclient said: " + s);

                msngReceived = (s.toUpperCase());

                byte[] sendBuffer = msngReceived.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                System.out.println("📤 Server respond: " + sendPacket);


                socket.send(sendPacket);

                socket.close();


            } catch (IOException e) {
            }
        }
    }


    // STEP1: Get your host and port

    private static InetAddress getHost() throws IOException {

        Scanner reader = new Scanner(System.in);
        System.out.print("🏨Enter Host: ");
        return InetAddress.getByName(reader.nextLine());
    }

    private static String getPort() {

        Scanner reader = new Scanner(System.in);
        System.out.print("🚪Enter PortNumber: ");
        return reader.nextLine();
    }

}
