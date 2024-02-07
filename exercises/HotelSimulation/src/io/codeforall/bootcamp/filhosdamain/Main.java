package io.codeforall.bootcamp.filhosdamain;

public class Main {

    public static void main(String[] args){

        Hotel hotel = new Hotel("MonksHotel", 5);
        Hotel hotel1 = new Hotel("HippoHotel", 5);
        Guest guest1 = new Guest("Baltazar", hotel);
        Guest guest2 = new Guest("Asdrubal", hotel);
        Guest guest3 = new Guest("Baltazar", hotel);
        Guest guest4 = new Guest("Asdrubal", hotel);
        Guest guest5 = new Guest("Baltazar", hotel);
        Guest guest6 = new Guest("Asdrubal", hotel1);
        Guest guest7 = new Guest("Baltazar", hotel1);
        Guest guest8 = new Guest("Asdrubal", hotel1);

        guest1.checkIn();
        guest1.checkIn();
        guest2.checkIn();
        guest3.checkIn();
        guest4.checkIn();
        guest2.checkOut();
        guest5.checkIn();
        guest6.checkIn();
        guest7.checkIn();
        guest6.checkOut();
        guest8.checkIn();

    }
}
