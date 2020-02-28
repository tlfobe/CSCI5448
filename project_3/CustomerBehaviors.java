// Abstract Behaviors

abstract class Behavior {
    private Customer customer;
    public Behavior( Customer customer) {
        this.customer = customer;
    }
}

abstract class RentCarBehavior extends Behavior {
    public RentCarBehavior(Customer customer) {
        super(customer);
    }
    public abstract void rentCars(Shop shop);
}

abstract class ReturnCarBehavior extends Behavior {
    public ReturnCarBehavior(Customer customer) {
        super(customer);
    }
    public abstract void returnCars(Shop shop);
}

// Concrete Behaviors

class CasualRentCar extends RentCarBehavior {
    public CasualRentCar(Customer customer) {
        super(customer);
    }
    public void rentCars(Shop shop) {
        // Rent 1 car
        // For 1 to 3 nights
    }
}

class BusinessRentCar extends RentCarBehavior {
    public BusinessRentCar(Customer customer) {
        super(customer);
    }
    public void rentCars(Shop shop) {
        // Rent 3 cars
        // for 7 nights
    }
}

class RegularRentCar extends RentCarBehavior {
    public RegularRentCar(Customer customer) {
        super(customer);
    }
    public void rentCars(Shop shop) {
        // Rent 1 to 3
        // for 3 to 5 nights
    }
}

class UniversalReturnCar extends ReturnCarBehavior {
    public UniversalReturnCar(Customer customer) {
        super(customer);
    }
    public void returnCars(Shop shop) {
        // Return all cars that have 0 days left
    }
}