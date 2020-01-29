import java.util.ArrayList;
import java.util.List;

public class CreateAnimals {
    public static void main(String[] args) {
        Animal dog = new Dog("Doug");
        Animal wolf = new Wolf("Wolfie");
        Animal fox = new Fox("Frank");
        Animal hippo = new Hippo("Hide");
        Animal elephant = new Elephant("Earnie");
        Animal tiger = new Tiger("Trunks");
        Animal lion = new Lion("Leon");
        Animal cat = new Cat2("Casper");

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


        // Animal doug = new Dog("Doug");
        // doug.roam();
        // doug.makeNoise();
        // doug.eatFood("Kibble");
        // doug.sleep();
        // Animal earnie = new Elephant("Earnie");
        // earnie.roam();
        // earnie.makeNoise();
        // earnie.eatFood("Hay");
        // earnie.sleep();
        // Animal casper = new Cat("Casper");
        // casper.roam();
        // casper.makeNoise();
        // casper.eatFood("Milk");
        // casper.sleep();

    }
}