package io.codeforall.bootcamp.filhosdamain;

public class Main {
    public static void main(String[] args) {



        // INTEGER EXAMPLE
        int i = 10;
        int j = 20;

        Machine<Integer> machineInteger = new Machine();

        Integer result = machineInteger.monoOperation(i,(number) -> number*number);
        System.out.println(result);

       // Integer result2 = machineInteger.biOperation(i,j,(number,number2) -> Integer.sum(number,number2);
        Integer result2 = machineInteger.biOperation(i,j,Integer::sum);
        System.out.println(result2);

        // STRING EXAMPLE

        String one = "Hey ";
        String two = "folks!";

        Machine<String> machineString = new Machine();

        BiOperation<String> lola = (oneS,twoS) -> oneS + twoS;
        // Lambda as an example of storing inside a variable.


        String resultString = machineString.monoOperation(one,(string) -> string+string);
        System.out.println(resultString);

        String resultString2 = machineString.biOperation(one,two,lola);
        System.out.println(resultString2);

        // String Exemple

        System.out.println(lola.biOperation(one,two));
    }
}
