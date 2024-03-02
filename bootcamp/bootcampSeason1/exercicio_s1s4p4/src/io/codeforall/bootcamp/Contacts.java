package io.codeforall.bootcamp;

public class Contacts {
    public static void main (String[] args) {
        AgendaPar newContact1 = new AgendaPar("Igor","Leandro");
        newContact1.email = "igorleandro@icloud.com";
        newContact1.phone = "915668346";
        newContact1.birthYear = 1992;

        System.out.println(newContact1.age(newContact1.birthYear, newContact1.currentYear));

        AgendaPar newContact2 = new AgendaPar("Edo","Rios");
        newContact2.email = "edorios@icloud.com";
        newContact2.phone = "910668668";
        newContact2.birthYear = 1975;
        System.out.println(newContact2.age(newContact2.birthYear, newContact2.currentYear));

        AgendaPar newContact3 = new AgendaPar("Aponi","Barros");
        newContact3.email = "aponibarros@icloud.com";
        newContact3.phone = "910668668";
        newContact3.birthYear = 1970;
        System.out.println(newContact3.age(newContact3.birthYear, newContact3.currentYear));



    }

    }

