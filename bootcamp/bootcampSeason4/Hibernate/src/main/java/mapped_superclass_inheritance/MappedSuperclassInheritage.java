package mapped_superclass_inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class MappedSuperclassInheritage {

    //Open Connection
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mapped_superclass_inheritance");

    public static void main(String[] args) {

        // Creating

        //Customer customer = new Customer();
        //customer.setName("Igor Leandro");
        //saveOrUpdate(customer);

        //Account account = new Account();
        //account.setBalance(53.50);
        //saveOrUpdate(account);


        //Find

        Customer findCustomer = findCustomer(4);
        Account foundbalance = findAccount(4);
        System.out.println("Name: " + findCustomer.getName() + " Balance: " + foundbalance.getBalance());


        // Update

        findCustomer.setName("Aponi Barros");
        foundbalance.setBalance(1230.40);
        saveOrUpdate(findCustomer);
        saveOrUpdate(foundbalance);

    }


    public static <T> void saveOrUpdate(T object) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            em.merge(object);
            em.getTransaction().commit(); // close transaction
        } catch (RollbackException ex) {
            em.getTransaction().rollback();
        } finally {
            // Close the EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    public static Customer findCustomer(Integer id) {

        Customer foundCustomer = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            // fetch a new user using its id
            foundCustomer = em.find(Customer.class, id); // always the primary key
            return foundCustomer;

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {

            // Close the database connection
            if (em != null) {
                em.close();
            }
        }
        return foundCustomer;
    }

    public static Account findAccount(Integer id) {

        Account foundAccount = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            // fetch a new user using its id
            foundAccount = em.find(Account.class, id); // always the primary key
            return foundAccount;

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {

            // Close the database connection
            if (em != null) {
                em.close();
            }
        }
        return foundAccount;
    }
}