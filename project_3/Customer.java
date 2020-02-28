import java.util.Random;
abstract class Customer {
    protected String name;
    // Might write extra constructors to set these if so desired
    protected boolean wantGPS = new Random().nextInt( 1 + 1 ) == 0;
    protected boolean wantSateliteRadio = new Random().nextInt( 1 + 1 ) == 0;
    protected int carSeats = new Random().nextInt( 3 + 1 );
    protected RentCarBehavior rent_car_behavior;
    protected ReturnCarBehavior return_car_behavior;

    public Customer(String name) {
        this.name = name;
    }

    public void rentCar( Shop shop ) {
        rent_car_behavior.rentCars(shop);
    }
    public void returnCar( Shop shop) {
        return_car_behavior.returnCars(shop);
    }

    protected void _setRentCarBehavior( RentCarBehavior rent_car_behavior ) {
        this.rent_car_behavior = rent_car_behavior;
    }
    protected void _setReturnCarBehavior( ReturnCarBehavior return_car_behavior ) {
        this.return_car_behavior = return_car_behavior;
    };
    
}

class CasualCustomer extends Customer {
    public CasualCustomer(String name) {
        super(name);
        _setRentCarBehavior( new CasualRentCar(this) );
        _setReturnCarBehavior(new UniversalReturnCar(this));
    }
}

class RegularCustomer extends Customer {
    public RegularCustomer(String name) {
        super(name);
        _setRentCarBehavior( new RegularRentCar(this) );
        _setReturnCarBehavior(new UniversalReturnCar(this));
    }
}

class BusinessCustomer extends Customer {
    public BusinessCustomer(String name) {
        super(name);
        _setRentCarBehavior( new BusinessRentCar(this) );
        _setReturnCarBehavior(new UniversalReturnCar(this));
    }
}

