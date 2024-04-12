package mapped_superclass_inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends AbstractModel {
    private Double balance;

    // Getter
    public Double getBalance() {
        return balance;
    }

    // Setter
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
