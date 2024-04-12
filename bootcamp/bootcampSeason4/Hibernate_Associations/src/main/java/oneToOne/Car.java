package oneToOne;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity (name="car")
@DiscriminatorValue("car")
public class Car {
    @Id
    private Integer id;
    private String maker;
    private String model;

    @OneToOne
    private Owner owner; // for bidirectionality

    // Getter

    public Integer getId() {
        return id;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public Owner getOwner() {
        return owner;
    }

    // Setter


    public void setId(Integer id) {
        this.id = id;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

