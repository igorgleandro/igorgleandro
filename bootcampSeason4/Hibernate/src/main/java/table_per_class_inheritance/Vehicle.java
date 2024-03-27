package table_per_class_inheritance;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer maxSpeed;


//Getter
    public Integer getId() {
        return id;
    }
    public Integer getMaxSpeed() {
        return maxSpeed;

    }

    //Setter
    public void setId(Integer id) {
        this.id = id;
    }


    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }



}
