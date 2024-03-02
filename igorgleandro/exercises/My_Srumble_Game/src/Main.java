import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final List<String> WORDS = new ArrayList<>();

    static {
        WORDS.add("apple");
        WORDS.add("banana");
        WORDS.add("orange");
        WORDS.add("strawberry");
        WORDS.add("pineapple");
        WORDS.add("watermelon");
        WORDS.add("grape");
        WORDS.add("kiwi");
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Waiting for Player 1 to connect...");
            Socket player1Socket = serverSocket.accept();
            System.out.println("Player 1 connected.");

            System.out.println("Waiting for Player 2 to connect...");
            Socket player2Socket = serverSocket.accept();
            System.out.println("Player 2 connected.");

            BufferedReader player1Input = new BufferedReader(new InputStreamReader(player1Socket.getInputStream()));
            PrintWriter player1Output = new PrintWriter(player1Socket.getOutputStream(), true);

            BufferedReader player2Input = new BufferedReader(new InputStreamReader(player2Socket.getInputStream()));
            PrintWriter player2Output = new PrintWriter(player2Socket.getOutputStream(), true);

            player1Output.println("Welcome, Player 1! Let's start the Scramble Word Game.");
            player2Output.println("Welcome, Player 2! Let's start the Scramble Word Game.");

            int score1 = 0;
            int score2 = 0;
            while (!WORDS.isEmpty()) {
                String word = selectRandomWord();
                String scrambledWord = scrambleWord(word);
                player1Output.println("Scrambled word: " + scrambledWord);
                player2Output.println("Scrambled word: " + scrambledWord);

                String answer1 = player1Input.readLine().toLowerCase();
                String answer2 = player2Input.readLine().toLowerCase();

                if (answer1.equals(word)) {
                    player1Output.println("Correct!");
                    score1++;
                } else {
                    player1Output.println("Incorrect! The correct answer was: " + word);
                }

                if (answer2.equals(word)) {
                    player2Output.println("Correct!");
                    score2++;
                } else {
                    player2Output.println("Incorrect! The correct answer was: " + word);
                }

                WORDS.remove(word);

                if (!WORDS.isEmpty()) {
                    player1Output.println("Your current score: " + score1);
                    player2Output.println("Your current score: " + score2);
                    player1Output.println("Next word:");
                    player2Output.println("Next word:");
                }
            }

            player1Output.println("Game over! Your final score is: " + score1);
            player2Output.println("Game over! Your final score is: " + score2);

            player1Socket.close();
            player2Socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String selectRandomWord() {
        Collections.shuffle(WORDS);
        return WORDS.get(0);
    }

    private static String scrambleWord(String word) {
        List<Character> characters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);

        StringBuilder scrambledWord = new StringBuilder();
        for (char c : characters) {
            scrambledWord.append(c);
        }
        return scrambledWord.toString();
    }
}

