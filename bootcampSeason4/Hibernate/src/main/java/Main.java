import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Main {

    //Open Connection
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

    public static void main(String[] args) {

        // Creating

        User user = new User();
        user.setName("Milene Gomes");
        user.setAge(22);
        saveOrUpdate(user);


        //Find

        User foundUser = findById(2);
        System.out.println("Name: " + foundUser.getName() + " Age: " + foundUser.getAge());


        // Update

        foundUser.setName("Igor Leandro");
        foundUser.setAge(28);
        saveOrUpdate(foundUser);


    }


    public static void saveOrUpdate(User user) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin(); // open transaction
            em.merge(user);
            em.getTransaction().commit(); // close transaction

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {

            // Close the database connection

            if (em != null) {
                em.close();
            }
        }
    }

    public static User findById(Integer id) {

        User foundUser = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            // fetch a new user using its id
            foundUser = em.find(User.class, id); // always the primary key
            return foundUser;

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {

            // Close the database connection
            if (em != null) {
                em.close();
            }
        }
        return foundUser;
    }
}