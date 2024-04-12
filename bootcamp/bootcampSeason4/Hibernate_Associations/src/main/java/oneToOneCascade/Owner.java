package oneToOneCascade;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    private Integer id;
    private String name;

    @OneToOne(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "owner"
    )
    private Car car;

    //Getter


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    //Setter


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
