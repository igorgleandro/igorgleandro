package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class MenuPrompt {

    public String loginMenu(){
    Prompt promptMenu = new Prompt(System.in, System.out);

    String[] options = {"1-Login.", "2-Enter Without Login", "3-Leave"};

    MenuInputScanner scanner = new MenuInputScanner(options);
        scanner.setMessage("PLEASE SELECT ONE OPTION");

    int answerMenuIndex = promptMenu.getUserInput(scanner);

        System.out.println("THE SELECTED OPTIONS IS: " + options[answerMenuIndex - 1]);
        System.out.println(options[answerMenuIndex - 1]);
        return options[answerMenuIndex - 1];

}
}
