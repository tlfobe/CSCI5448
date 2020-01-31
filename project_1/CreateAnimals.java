import java.util.ArrayList;
import java.util.List;

public class CreateAnimals {
    public static void main(String[] args) {
        // create a list of zoo animals and then fun specific zookeeper commands.

        Animal dog = new Dog("Doug");
        Animal wolf = new Wolf("Wolfie");
        Animal fox = new Fox("Frank");
        Animal hippo = new Hippo("Hide");
        Animal elephant = new Elephant("Earnie");
        Animal tiger = new Tiger("Trunks");
        Animal lion = new Lion("Leon");
        Animal cat = new Cat("Casper");

        List<Animal> zoo = new ArrayList<Animal> ();

        zoo.add(dog);
        zoo.add(wolf);
        zoo.add(fox);
        zoo.add(hippo);
        zoo.add(elephant);
        zoo.add(tiger);
        zoo.add(lion);
        zoo.add(cat);

        Zookeeper Zeke = new Zookeeper("Zeke", zoo);


        Zeke.wakeUpAnimals();
        Zeke.rollCall();
        Zeke.feedTheAnimals();
        Zeke.exerciseTheAnimals();
        Zeke.goToSleep();

    }
}