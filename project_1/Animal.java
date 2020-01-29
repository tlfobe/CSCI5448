import java.util.Random;
import java.util.ArrayList;

abstract class Animal {
    
    protected String name;
    public String animalType;
    abstract public void roam();
    abstract public void makeNoise();
    abstract public void eatFood(String food);

    public Animal(String name) {
        this.name = name;
        this.animalType = this.getClass().getSimpleName();
    }

    public void sleep() {
        System.out.println(this.name + " the " + this.animalType + ": ZZZZZZZZZZZZZZZZZZZZ");
    }
}

abstract class Feline extends Animal {
    public Feline(String name) {
        super(name);
    }
    public void roam() {
        System.out.println(this.name + " the " + this.animalType +  " lazily pads around the den.");
    }
}

abstract class Pachyderm extends Animal {
    public Pachyderm(String name) {
        super(name);
    }
    public void roam(){
        System.out.println(this.name + " the " + this.animalType + " slowly waddles around the field");
    }
}

abstract class Canine extends Animal {
    public Canine(String name) {
        super(name);
    }
    public void roam(){
        System.out.println(this.name + " the " + this.animalType + " exicitedly runs around the yard");
    }
    
}

class Dog extends Canine {
    public Dog(String name) {
        super(name);
    }
    public final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Woof!");
    }
    public final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Nom Nom Nom!");
        System.out.println("Pieces of " + food + " are littered all over the floor!");
    }
}

class Wolf extends Canine {
    public Wolf(String name) {
        super(name);
    }
    public final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Awooooo!");
    }
    public final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Chomp Chomp Chomp!");
        System.out.println("Shreded morsels of " + food + " are scattered all over the floor!");
    }
}

class Fox extends Canine {
    public Fox(String name) {
        super(name);
    }
    public final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Awooooo!");
    }
    public final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Chomp Chomp Chomp!");
        System.out.println("Tiny shreds of " + food + " are sprinkled all over the floor!");
    }
}

class Hippo extends Pachyderm {
    public Hippo(String name) {
        super(name);
    }
    public final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Huff Huff Huff!");
    }
    public final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Flap Flap Flap");
        System.out.println(this.name + " the " + this.animalType + " powerfully crushes the " + food + " in one bite!");
    }
}

class Elephant extends Pachyderm {
    public Elephant(String name) {
        super(name);
    }
    public final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Twoot Twooooot!");
    }
    public final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Crunch Crunch Crunch");
        System.out.println(this.name + " the " + this.animalType + " gingerly eats the " + food + " with its trunk!");
    }
}
class Tiger extends Feline {
    public Tiger(String name) {
        super(name);
    }
    public final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Roaaar Roaar!");
    }
    public final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Crunch Crunch!");
        System.out.println("Pieces of " + food + " cling to " + this.name + "'s paws!");
    }
}

class Lion extends Feline {
    public Lion(String name) {
        super(name);
    }
    public final void makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Roaaar Roaar!");
    }
    public final void eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Crunch Crunch!");
        System.out.println("Pieces of " + food + " cling to " + this.name + "'s mane!");
    }
}


class Cat extends Feline {

    interface doAction {
        void action();
    }
    private doAction[] catMethods = new doAction[] {
        new doAction() { public void action() {_sleep(); } },
        new doAction() { public void action() {_makeNoise(); } },
        new doAction() { public void action() {_roam(); } },
        new doAction() { public void action() {_eatFood("Fish"); } },
        new doAction() { public void action() {_hiss(); } }
    };
    public Cat(String name) {
        super(name);
    }
    public void doAnything(int desired_method) {
        Random rand = new Random();
        int i = rand.nextInt(5);
        while (i != desired_method) {          
            catMethods[i].action();
            i = rand.nextInt(5);
        }
    }
    public void sleep() {
        doAnything(0);
        _sleep();
    }

    public void makeNoise() {
        doAnything(1);
        _makeNoise();
    }

    public void eatFood(String food) {
        doAnything(3);
        _eatFood(food);
    }

    public void roam() {
        doAnything(2);
        _roam();
    }

    private void _makeNoise() {
        System.out.println(this.name + " the " + this.animalType + ": Meeeooooown!");
    }
    private void _sleep() {
        super.sleep();
    }
    private void _eatFood(String food) {
        System.out.println(this.name + " the " + this.animalType + ": Slurp Slurp Slurp!");
        System.out.println("Not a trace of " + food + " is left in the bowl!");
    }
    private void _hiss() {
        System.out.println(this.name + " the " + this.animalType + ": Hissssssssss!");
    }
    private void _roam() {
        super.roam();
    }
}