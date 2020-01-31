import java.util.List;

class Zookeeper {
    public String name;
    List<Animal> zoo;

    public Zookeeper(String name, List<Animal> zoo) {
        this.name = name;
        this.zoo = zoo;        
    }

    // each action iterates over all animals
    public void wakeUpAnimals() {
        System.out.println("-----  WAKE UP THE ANIMALS  -----");
        for (Animal animal : zoo) {
            System.out.println(name + " wakes up " + animal.name + " the " + animal.animalType + ".");
        }
    }

    public void rollCall() {
        System.out.println("-----  ROLL CALL  -----");
        for (Animal animal : zoo) {
            animal.makeNoise();
        }
    }

    public void feedTheAnimals() {
        System.out.println("-----  FEEDING TIME  -----");
        for (Animal animal : zoo) {
            System.out.println(name + " feeds " + animal.name +  " the " + animal.animalType  + ".");
            animal.eatFood("food"); 
        }
    }

    public void exerciseTheAnimals() {
        System.out.println("-----  TIME TO WORKOUT  -----");
        for (Animal animal : zoo) {
            System.out.println(name + " exercises " + animal.name + " the " + animal.animalType +  ".");
            animal.roam();
        }
    }

    public void goToSleep() {
        System.out.println("-----  SHUTTING DOWN THE ZOO  -----");
        for (Animal animal : zoo) {
            System.out.println(name + " makes " + animal.name + " the " + animal.animalType +  " go to sleep!");
        }
    }



}