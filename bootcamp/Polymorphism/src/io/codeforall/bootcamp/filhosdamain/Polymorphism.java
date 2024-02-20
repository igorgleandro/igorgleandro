package io.codeforall.bootcamp.filhosdamain;

public class Polymorphism {

     public static void main(String[] args) {
       /* Animal myAnimal = new Animal();
        myAnimal.sound();

        Animal myDog = new Dog();
        myDog.sound();

        Cat myCat = new Cat();
        myCat.sound();

    }*/









       Animal myAnimal = new Cat();
        doAnimalStuff(myAnimal);
    }

    public static void doAnimalStuff(Animal animal) {

        animal.sound();

        if (animal instanceof Dog) {
            Dog myAnimal = (Dog) animal;
            myAnimal.growl();
        }
        }


}



