package io.codeforall.bootcamp.filhosdamain;
import java.io.*;
import java.util.*;

public class FileAnalyzer {
    public static void main(String[] args) {

        // Path to the input files
        String file1Path = "src/file1.txt";
        String file2Path = "src/file2.txt";

        // Test each operation
        try {
            // Reading and counting number of words
            int wordCountFile1 = countWords(file1Path);
            int wordCountFile2 = countWords(file2Path);
            System.out.println("Word count in file1.txt: " + wordCountFile1);
            System.out.println("Word count in file2.txt: " + wordCountFile2);

            // Finding the first word longer than n characters
            int n = 5; // Change n to any desired length
            String firstLongWordFile1 = findFirstLongWord(file1Path, n);
            String firstLongWordFile2 = findFirstLongWord(file2Path, n);
            System.out.println("First word longer than " + n + " characters in file1.txt: " + firstLongWordFile1);
            System.out.println("First word longer than " + n + " characters in file2.txt: " + firstLongWordFile2);

            // Getting the longest n words
            int longestN = 3; // Change longestN to any desired value
            List<String> longestWordsFile1 = getLongestWords(file1Path, longestN);
            List<String> longestWordsFile2 = getLongestWords(file2Path, longestN);
            System.out.println("Longest " + longestN + " words in file1.txt: " + longestWordsFile1);
            System.out.println("Longest " + longestN + " words in file2.txt: " + longestWordsFile2);

            // Finding the common words between two files
            List<String> commonWords = findCommonWords(file1Path, file2Path);
            System.out.println("Common words between file1.txt and file2.txt: " + commonWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read and count the number of words in a file
    public static int countWords(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int wordCount = 0;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        reader.close();
        return wordCount;
    }

    // Method to find the first word longer than n characters in a file
    public static String findFirstLongWord(String filePath, int n) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.length() > n) {
                    reader.close();
                    return word;
                }
            }
        }
        reader.close();
        return null;
    }

    // Method to get the longest n words in a file
    public static List<String> getLongestWords(String filePath, int n) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(String::length).reversed());
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                pq.offer(word);
            }
        }
        List<String> longestWords = new ArrayList<>();
        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            longestWords.add(pq.poll());
        }
        reader.close();
        return longestWords;
    }

    // Method to find common words between two files
    public static List<String> findCommonWords(String filePath1, String filePath2) throws IOException {
        Set<String> words1 = new HashSet<>();
        Set<String> commonWords = new HashSet<>();
        BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
        String line;
        while ((line = reader1.readLine()) != null) {
            String[] words = line.split("\\s+");
            words1.addAll(Arrays.asList(words));
        }
        reader1.close();

        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
        while ((line = reader2.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (words1.contains(word)) {
                    commonWords.add(word);
                }
            }
        }
        reader2.close();
        return new ArrayList<>(commonWords);
    }
}
