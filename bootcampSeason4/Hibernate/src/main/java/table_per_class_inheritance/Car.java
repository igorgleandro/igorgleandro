package table_per_class_inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car_table_per_class")
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


