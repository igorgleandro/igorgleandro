package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Script {

    public static void main(String[] args) throws InterruptedException {

        MenuPrompt menuPrompt = new MenuPrompt();
        Prompt prompt = new Prompt(System.in, System.out);

        String ansMenuLogin = "1-Login.";
        String ansMenuEnterNoLogin = "2-Enter Without Login";
        String ansMenuLeave = "3-Leave";


        System.out.println("_________________________________\n Welcome to the iGor_message\n_________________________________");

        String answerMenuIndex = menuPrompt.loginMenu();
        if (answerMenuIndex.equals(ansMenuLogin)) {

            StringInputScanner questionUsername = new StringInputScanner();
            questionUsername.setMessage("USERNAME: ");
            

            String username = prompt.getUserInput(questionUsername);

            StringInputScanner questionPass = new StringInputScanner();
            questionUsername.setMessage("PASSWORD: ");

            String password = prompt.getUserInput(questionPass);



            System.out.println("User's name: " + username + " | User's Password: " + password);
        }


    }

}
