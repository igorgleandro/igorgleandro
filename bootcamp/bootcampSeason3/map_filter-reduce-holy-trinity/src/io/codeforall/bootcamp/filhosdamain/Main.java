package io.codeforall.bootcamp.filhosdamain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";


      String[] messageNoGarbage = message.split(" ");

        System.out.println(Stream.of(messageNoGarbage)
                .filter(messageGarbage -> !messageGarbage.contains("garbage"))
                .map(messageGarbage -> new String(messageGarbage))
                .collect(Collectors.joining(" ")).toUpperCase());
    }
}

