package single_table_inheritance;

import javax.persistence.*;

@Entity(name="VehicleSingleTable")
@Table(name = "vehicle_single_table")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "vehicle_type",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
