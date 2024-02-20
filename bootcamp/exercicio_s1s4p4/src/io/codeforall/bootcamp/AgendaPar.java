package io.codeforall.bootcamp;

public class AgendaPar {

    public int currentYear = 2024;
    public String name;
    public String surname;
    public String email;
    public String phone;
    public int birthYear;

    public AgendaPar(String name, String surname) {
        this.name = name ;
        this.surname = surname;
        System.out.println("Surname:   Name:");
        System.out.println( surname + " , " + name);
    }

    public int age(int birthYear, int currentYear){
        return birthYear - currentYear;
    }

}