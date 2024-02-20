package io.codeforall.bootcamp;

public class TravelPack {
    private String country;
    private String city;
    private String date;
    private String region;
    private String dope;
    private String nope;

    public TravelPack(String country, String city) {
        this.country = country;
        this.city = city;
        System.out.println("Country:   City:");
        System.out.println(country + " , " + city);

        // GETTER
        public String getDate() {
            return this.date;
        }

        //SETTER
        public void setDate(){
            this.date = date;


    }

    public void CityDetail() {

        System.out.println("Located at: " + region);
        System.out.println("Nope!: " + nope);
        System.out.println("Dope!: " + dope);
        System.out.println("_________________________________________________________________________________");
        System.out.println("_________________________________________________________________________________");
    }

}
