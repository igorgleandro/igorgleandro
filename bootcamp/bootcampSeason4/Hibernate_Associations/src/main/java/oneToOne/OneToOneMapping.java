package oneToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class OneToOneMapping {

    //Open Connection
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");

    public static void main(String[] args) {

        // Creating

        Owner owner = createOwner("Igor Gomes", 2);
        Car car = createCar("BMW", "M1", owner,2);


        //Find

        Car findCar = findCar(1);
        System.out.println("Car ID: " + findCar.getId() + " is a: " + findCar.getMaker() + "Owned by: " + findCar.getOwner());


        // Update

        updateCar(findCar,"Nissan","Leaf", findCar.getOwner(),findCar.getId());


        emf.close();

    }

    private static Owner createOwner(String name, int id) {
        Owner owner = new Owner();
        owner.setName(name);
        owner.setId(id);
        saveOrUpdate(owner);
        return owner;
    }

    private static Car createCar(String setMaker, String setModel, Owner setOwner, int id) {
        Car car = new Car();
        car.setMaker(setMaker);
        car.setModel(setModel);
        car.setOwner(setOwner);
        car.setId(id);
        saveOrUpdate(car);
        return car;
    }

    private static Car updateCar(Car car, String setMaker, String setModel, Owner setOwner, int id) {
        car.setMaker(setMaker);
        car.setModel(setModel);
        car.setOwner(setOwner);
        car.setId(id);
        saveOrUpdate(car);
        return car;
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

    public static Car findCar(Integer id) {

        Car findCar = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin(); // open transaction
            // fetch a new user using its id
            findCar = em.find(Car.class, id); // always the primary key
            return findCar;

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {

            // Close the database connection
            if (em != null) {
                em.close();
            }
        }
        return findCar;
    }
}


