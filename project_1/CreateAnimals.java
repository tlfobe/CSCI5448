public class CreateAnimals {
    public static void main(String[] args) {
        Animal doug = new Dog("Doug");
        doug.roam();
        doug.makeNoise();
        doug.eatFood("Kibble");
        doug.sleep();
        Animal earnie = new Elephant("Earnie");
        earnie.roam();
        earnie.makeNoise();
        earnie.eatFood("Hay");
        earnie.sleep();
        Animal casper = new Cat("Casper");
        casper.roam();
        casper.makeNoise();
        casper.eatFood("Milk");
        casper.sleep();
    }
}