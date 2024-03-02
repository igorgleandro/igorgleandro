package io.codeforall.bootcamp.filhosdamain;// Java Program to demonstrate
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Driver Class 
public class ShuffleString {

    public static String shuffleString(String input) {

        // Convert String to a list of Characters 
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }

        // Shuffle the list 
        Collections.shuffle(characters);

        // Convert the list back to String 
        StringBuilder shuffledString = new StringBuilder();
        for (char c : characters) {
            shuffledString.append(c);
        }

        return shuffledString.toString();
    }

} 