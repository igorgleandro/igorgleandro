package companent_mapping;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String city;
    private String zipcode;

    //Getter

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    // Setter

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
