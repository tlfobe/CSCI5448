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

    abstract int rentCars(Shop shop);

    protected void  generalRentCars(Shop shop, int n_cars, int n_nights) {
        float payment = 0;
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
            

            System.out.printf("%-8s %-11s %-5s %-13s %-8s $%-10.2f\n",
                                car.licensePlate,
                                car.getBase().getClass().getSimpleName(),
                                String.valueOf(wantGPS),
                                String.valueOf(wantSateliteRadio),
                                String.valueOf(carSeats),
                                car.cost());
            // System.out.print(car.licensePlate + " ");
            // System.out.print(car.getBase().getClass().getSimpleName() + " ");
            // System.out.print(String.valueOf(wantGPS)+ " ");
            // System.out.print(String.valueOf(wantSateliteRadio)+ " ");
            // System.out.print(String.valueOf(carSeats)+ " ");
            // System.out.println("$"+String.valueOf(car.cost()));
            payment += car.cost();
        }
        System.out.println();
        System.out.println("Rental Duration: " + String.valueOf(n_nights) + " Days");
        System.out.println("Rental Total Cost: $" + String.valueOf(payment));
        shop.collectPayment(payment);
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
    public int rentCars(Shop shop) {
        // Rent 1 car
        // For 1 to 3 nights
        int n_nights = new Random().nextInt(2 + 1) + 1;
        int n_cars = 1;
        generalRentCars(shop, n_cars, n_nights);
        return n_cars;
    }
}

class BusinessRentCar extends RentCarBehavior {
    public BusinessRentCar(Customer customer) {
        super(customer);
    }
    public int rentCars(Shop shop) {
        int n_nights = 7;
        int n_cars = 3;
        generalRentCars(shop, n_cars, n_nights);
        return n_cars;
    }
}

class RegularRentCar extends RentCarBehavior {
    public RegularRentCar(Customer customer) {
        super(customer);
    }
    public int rentCars(Shop shop) {
        // Rent 1 to 3
        // for 3 to 5 nights
        // should probably implement a check to make
        //  sure we don't pull from an empty shop
        int n_nights = new Random().nextInt(2 + 1) + 3;
        int range_cars = Math.min(shop.size(), Math.min(3, 3 - customer.rented_cars.size())) - 1;
        // System.out.println(range_cars);
        int n_cars = new Random().nextInt(range_cars + 1) + 1;
        generalRentCars(shop, n_cars, n_nights);
        return n_cars;
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