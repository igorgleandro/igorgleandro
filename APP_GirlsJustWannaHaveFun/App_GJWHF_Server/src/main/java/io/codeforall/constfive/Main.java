package io.codeforall.constfive;

import static io.codeforall.constfive.ClubList.CLUB_LIST;

public class Main {

    public static void main(String[] args) {

        System.out.println(ClubList.getClub(Type.NIGHTCLUB, City.PORTO, Genre.POP) + "\n");
        System.out.println(ClubList.getClub(null, City.PORTO, null) + "\n");
        for (Club c: CLUB_LIST){
            System.out.println(c);
        }

    }
}
