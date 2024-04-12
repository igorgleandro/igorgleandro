package table_per_class_inheritance;

import single_table_inheritance.Boat;
import single_table_inheritance.Car;
import single_table_inheritance.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class TablePerClassInheritance {

    //Open Connection
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("table_per_class_inheritance");

    public static void main(String[] args) {

        // Creating

        Car vehicle = new Car();
        vehicle.setMaxSpeed(220);
        vehicle.setGears(5);
        vehicle.setId(1);
        saveOrUpdate(vehicle);

       /* Boat vehicle2 = new Boat();
        vehicle2.setMaxSpeed(150);
        vehicle2.setEngines(3);
        saveOrUpdate(vehicle2);*/

        //Find

        Vehicle findVehicle = findVehicle(1);
        System.out.println("Vehicle: " + findVehicle.getId() + " is a: " + findVehicle.getMaxSpeed());


        // Update

        //findCustomer.setName("Aponi Barros");
        //foundbalance.setBalance(1230.40);
        //saveOrUpdate(findCustomer);
        //saveOrUpdate(foundbalance);

        emf.close();

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

    public static Vehicle findVehicle(Integer id) {

        Vehicle findVehicle = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            // fetch a new user using its id
            findVehicle = em.find(Vehicle.class, id); // always the primary key
            return findVehicle;

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {

            // Close the database connection
            if (em != null) {
                em.close();
            }
        }
        return findVehicle;
    }
}

