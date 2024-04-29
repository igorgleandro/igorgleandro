package io.codeforall.constfive;

public class Club {

    private String name;
    private String address;
    private Type type;
    private City city;
    private Genre genre;
    private String imgLink;

    private String embeddedMap;

    public String getEmbeddedMap() {
        return embeddedMap;
    }

    public void setEmbeddedMap(String embeddedMap) {
        this.embeddedMap = embeddedMap;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Club(String name, String address, Type type, City city, Genre genre, String imgLink, String embeddedMap) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.city = city;
        this.genre = genre;
        this.imgLink = imgLink;
        this.embeddedMap = embeddedMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Club{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", city=" + city +
                ", genre=" + genre +
                '}';
    }
}
