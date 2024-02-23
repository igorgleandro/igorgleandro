package io.codeforall.bootcamp.filhosdamain;

public class TrabalhadorDasCaldas implements Runnable {

    @Override
    public void run() {


        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("TRABALHADOR: Estou aqui a efetuar umas louças");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Estava a dormir e me acordaram ");
            }
        }
            System.out.println("Trabalhador: Ja nao faco um caralho.");
        }
    }

