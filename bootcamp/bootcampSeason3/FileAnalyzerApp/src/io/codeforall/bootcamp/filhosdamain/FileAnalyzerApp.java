package io.codeforall.bootcamp.filhosdamain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileAnalyzerApp {
    public static void main(String[] args) throws IOException {


        // Path to the input files
        String file1Path = "resources/file1.txt";
        String file2Path = "resources/file2.txt";


        int counter = countWords(file1Path);
        System.out.println("📁The File " + file1Path + " have " + counter + " words.");

        System.out.println(firstWordLonger(file1Path));


        int counter2 = countWords(file2Path);
        System.out.println("📁The File " + file1Path + " have " +counter2 + " words.");

        System.out.println(firstWordLonger(file2Path));

        System.out.println(longestNwords(file1Path, counter));
        System.out.println(longestNwords(file2Path, counter2));




        // Reading and counting number of Words.
    }


    public static int countWords(String filePath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int wordCounter = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCounter += words.length;
        }
        return wordCounter;

    }

    public static String firstWordLonger(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() >= 10) {
                    return ("💬The word: " + words[i].toUpperCase() + " have more than 10 characters");
                }
            }
        }
        return line;
    }

    /*public static String[] longestNwords(String filePath, int counter) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;


        String[] bigWords = new String[50];


        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");

            for (int i = 0; i < words.length; i++){


                if (words[i].length() >= 10) {
                    for (int j = 0; j < 1; j++){
                        bigWords[j] = words[i];
                        System.out.println(bigWords[j]);



                    }

                }
            } */

        public static String[] longestNwords (String filePath ) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    String
            }

            Stream<BufferedReader> bufferedReaderStream = Stream.of(reader);


                    //String[] messageNoGarbage = message.split(" ");


        }



           }


}

