import java.util.Random;

abstract class Animal {
    
    protected String name;
    public String animalType;
    abstract void roam();
    abstract void makeNoise();
    abstract void eatFood(String food);

    final void sleep() {
        System.out.println(this.name + " the " + this.animalType + ": ZZZZZZZZZZZZZZZZZZZZ");
    }
    public Animal(String name) {
        this.name = name;
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
        this.animalType = "Dog";
    }
    final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Woof!");
    }
    final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Nom Nom Nom!");
    }
}