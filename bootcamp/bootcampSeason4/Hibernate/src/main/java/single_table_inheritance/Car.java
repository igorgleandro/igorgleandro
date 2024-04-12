package single_table_inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity (name="CarSingleTable")
@DiscriminatorValue("car")
public class Car extends Vehicle {

    private Integer gears;

    //Getter

    public Integer getGears() {
        return gears;
    }

    //Setter

    public void setGears(Integer gears) {
        this.gears = gears;
    }
}
