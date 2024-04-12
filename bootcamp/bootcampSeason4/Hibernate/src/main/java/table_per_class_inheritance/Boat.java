package table_per_class_inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boat_table_per_class")
public class Boat extends Vehicle {

    private Integer engines;

    //Getter

    public Integer getEngines() {
        return engines;
    }

    //Setter

    public void setEngines(Integer engines) {
        this.engines = engines;
    }


}
