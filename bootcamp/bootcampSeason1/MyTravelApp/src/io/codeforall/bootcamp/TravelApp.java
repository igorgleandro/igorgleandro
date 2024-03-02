package io.codeforall.bootcamp;

public class TravelApp {
    public static void main (String[] args){


            String search = "Peru";

            // initial comment block
            System.out.println("That's my traveled countries list:");
            System.out.println(" ");
            System.out.println(" |  |  |  |  |  |  |  |  |  |");
            System.out.println(" V  V  V  V  V  V  V  V  V  V ");
            System.out.println(" ");


switch (search){
        case ( "Argentina"):
            // Latin America List

            TravelPack NewCountry = new TravelPack("Argentina","Buenos Aires");
            NewCountry.region = "Latin America";
            NewCountry.getDate() = "April, 1, 2022";
            NewCountry.dope = "Super affordable, restaurants options, well connected with the world";
            NewCountry.nope = "Crazy exchange, high crime rate";
            NewCountry.CityDetail();
                break;


        case ("Uruguay"):
            TravelPack NewCountry1 = new TravelPack("Uruguay","Montevideo");
            NewCountry1.getDate() = "Jan , 14 , 2022";
            NewCountry1.region = "Latin America";
            NewCountry1.dope = "Easy and calm life, people are nice";
            NewCountry1.nope = "Excessive expensive, not much to do";
            NewCountry1.CityDetail();
            break;

        case("Peru"):
                TravelPack NewCountry2 = new TravelPack("Peru","Lima");
                NewCountry2.getDate() = "Jun , 01 , 2018";
                NewCountry2.region = "Latin America";
                NewCountry2.dope = "The best food in the world! People are nice, the culture is amazing";
                NewCountry2.nope = "Not so cheap for Latin America, traffic is bad, not so safe.";
                NewCountry2.CityDetail();
                break;

        case("Brazil"):
                TravelPack NewCountry3 = new TravelPack("Brazil","Sao Paulo");
                NewCountry3.getDate() = "Jun , 01 , 2018";
                NewCountry3.region = "Latin America";
                NewCountry3.dope = "People super nice, very welcoming country, good food, good parties.";
                NewCountry3.nope = "Bad Traffic, Not so cheap for Latin America, not safe at all on the streets";
                NewCountry3.CityDetail();
                break;




    }
}}
