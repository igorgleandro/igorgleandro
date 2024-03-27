package single_table_inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="BoatSingleTable")
@DiscriminatorValue("boat")
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