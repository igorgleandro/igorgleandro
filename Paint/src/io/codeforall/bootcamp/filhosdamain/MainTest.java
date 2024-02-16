package io.codeforall.bootcamp.filhosdamain;

public class MainTest {
    public static void main(String[] args) {

        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                System.out.print("x");
            }
            // When you're done printing the "x"s for the row, start a new row.
            System.out.print("\n");
        }
    }
}
