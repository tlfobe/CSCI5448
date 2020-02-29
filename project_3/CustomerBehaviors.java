import java.util.Random;


// Abstract Behaviors

abstract class Behavior {
    protected Customer customer;
    public Behavior( Customer customer) {
        this.customer = customer;
    }
}

abstract class RentCarBehavior extends Behavior {
    public RentCarBehavior(Customer customer) {
        super(customer);
    }
    public void rentCars(Shop shop) {
        boolean wantGPS = new Random().nextInt( 1 + 1 ) == 0;
        boolean wantSateliteRadio = new Random().nextInt( 1 + 1 ) == 0;
        int carSeats = new Random().nextInt( 3 + 1 );
    }
}

abstract class ReturnCarBehavior extends Behavior {
    public ReturnCarBehavior(Customer customer) {
        super(customer);
    }
    public abstract void returnCar(Shop shop, Car car);
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
    public void returnCar(Shop shop, Car car) {
        int i_rm = customer.rented_cars.indexOf(car);
        customer.rented_cars.remove(car);
        customer.days_left.remove(i_rm);
        shop.release(car);
    }
}