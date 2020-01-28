import java.util.Random;

abstract class Animal {
    
    protected String name;
    public String animalType;
    abstract void roam();
    abstract void makeNoise();
    abstract void eatFood(String food);

    public Animal(String name) {
        this.name = name;
        this.animalType = this.getClass().getSimpleName();
    }

    final void sleep() {
        System.out.println(this.name + " the " + this.animalType + ": ZZZZZZZZZZZZZZZZZZZZ");
    }
}

abstract class Feline extends Animal {
    public Feline(String name) {
        super(name);
    }
    void doAnything() {
        Random rand = new Random();
        int i = 0;
        while (i <= 8) {
            i = rand.nextInt(20);
        }
            // roam();
            // makeNoise();
            // eatFood();
            // hiss();
        
    }
    
    final void roam() {
        doAnything();
        System.out.println(this.name + " the " + this.animalType +  " lazily pads around the den.");
    }
}

abstract class Pachyderm extends Animal {
    public Pachyderm(String name) {
        super(name);
    }
    final void roam(){
        System.out.println(this.name + " the " + this.animalType + " slowly waddles around the field");
    }
}

abstract class Canine extends Animal {
    public Canine(String name) {
        super(name);
    }
    final void roam(){
        System.out.println(this.name + " the " + this.animalType + " exicitedly runs around the yard");
    }
    
}

class Dog extends Canine {
    public Dog(String name) {
        super(name);
    }
    final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Woof!");
    }
    final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Nom Nom Nom!");
        System.out.println("Pieces of " + food + " are littered all over the floor!");
    }
}

class Wolf extends Canine {
    public Wolf(String name) {
        super(name);
    }
    final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Awooooo!");
    }
    final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Chomp Chomp Chomp!");
        System.out.println("Shreded morsels of " + food + " are scattered all over the floor!");
    }
}

class Fox extends Canine {
    public Fox(String name) {
        super(name);
    }
    final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Awooooo!");
    }
    final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Chomp Chomp Chomp!");
        System.out.println("Tiny shreds of " + food + " are sprinkled all over the floor!");
    }
}

class Hippo extends Pachyderm {
    public Hippo(String name) {
        super(name);
    }
    final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Huff Huff Huff!");
    }
    final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Flap Flap Flap");
        System.out.println(this.name + " the " + this.animalType + " powerfully crushes the " + food + " in one bite!");
    }
}

class Elephant extends Pachyderm {
    public Elephant(String name) {
        super(name);
    }
    final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Twoot Twooooot!");
    }
    final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Crunch Crunch Crunch");
        System.out.println(this.name + " the " + this.animalType + " gingerly eats the " + food + " with its trunk!");
    }
}