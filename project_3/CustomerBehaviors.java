import java.util.Random;


// Abstract Behaviors

abstract class Behavior {
    protected Customer customer;
    public Behavior( Customer customer) {
        this.customer = customer;
    }
}

abstract class RentCarBehavior extends Behavior {
    boolean wantGPS;
    boolean wantSateliteRadio;
    int carSeats;
    public RentCarBehavior(Customer customer) {
        super(customer);
    }
    public void setPrefences(Shop shop) {
        wantGPS = new Random().nextInt( 1 + 1 ) == 0;
        wantSateliteRadio = new Random().nextInt( 1 + 1 ) == 0;
        carSeats = new Random().nextInt( 3 + 1 );
    }

    abstract void rentCars(Shop shop);

    protected void generalRentCars(Shop shop, int n_cars, int n_nights) {
        for (int i = 0; i < n_cars; i++) {
            Car car = shop.get(n_nights);
            setPrefences(shop); // gives different preferences per car
            if (wantGPS == true) {
                car = new GPS(car);
            }
            if (wantSateliteRadio == true) {
                car = new SateliteRadio(car);
            }
            for (int j = 0; j < carSeats; j++) {
                car = new CarSeat(car);
            }
            customer.rented_cars.add(car);
            customer.days_left.add(n_nights);

            System.out.println("CarType: " + car.getBase().getClass().getSimpleName());
            System.out.println("GPS: " + String.valueOf(wantGPS));
            System.out.println("Satelite Radio: " + String.valueOf(wantSateliteRadio));
            System.out.println("Car Seats: " + String.valueOf(carSeats));

            shop.collectPayment(car.cost());
        }
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
        int n_nights = new Random().nextInt(2 + 1) + 1;
        int n_cars = 1;
        generalRentCars(shop, n_cars, n_nights);
    }
}

class BusinessRentCar extends RentCarBehavior {
    public BusinessRentCar(Customer customer) {
        super(customer);
    }
    public void rentCars(Shop shop) {
        int n_nights = 7;
        int n_cars = 3;
        generalRentCars(shop, n_cars, n_nights);
    }
}

class RegularRentCar extends RentCarBehavior {
    public RegularRentCar(Customer customer) {
        super(customer);
    }
    public void rentCars(Shop shop) {
        // Rent 1 to 3
        // for 3 to 5 nights
        // should probably implement a check to make
        //  sure we don't pull from an empty shop
        int n_nights = new Random().nextInt(2 + 1) + 3;
        int range_cars = Math.min(shop.size(), 3) - 1;
        int n_cars = new Random().nextInt(range_cars + 1) + 1;
        generalRentCars(shop, n_cars, n_nights);
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