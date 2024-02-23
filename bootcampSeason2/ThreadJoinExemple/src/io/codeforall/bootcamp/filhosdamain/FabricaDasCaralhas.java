package io.codeforall.bootcamp.filhosdamain;

public class FabricaDasCaralhas {
    public static void main(String[] args) {
        System.out.println("GERENTE: cheguei, comece a fazer louças");

        Thread trabalhador = new Thread(new TrabalhadorDasCaldas());
        trabalhador.start();

        Thread outroTrabalhador = new Thread((new TrabalhadorDasCaldas()));
        outroTrabalhador.start();

        try{
            System.out.println("GERENTE: A espera que terminem");
            trabalhador.join();
            outroTrabalhador.join();
        }catch(InterruptedException e){}




        System.out.println("GERENTE: Finalmente acabaram vou a casa.");
    }
}
