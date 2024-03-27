package mapped_superclass_inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

    @Entity
    @Table(name = "customer")
    public class Customer extends AbstractModel {

        private String name;


        //GETTER
        public String getName() {
            return name;
        }

        // SETTER

        public void setName(String name) {
            this.name = name;
        }


    }
