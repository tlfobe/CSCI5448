import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
interface Observer {
    public void update();
}

abstract class Customer implements Observer {
    protected String name;
    // Abstract 

    protected RentCarBehavior rent_car_behavior;
    protected ReturnCarBehavior return_car_behavior;
    protected List< Car > rented_cars;
    protected List< Integer > days_left;
    protected Shop subject;
    protected boolean is_viable;

    abstract protected void updateViable(int n_cars_available);

    // Implementation

    public Customer(String name, Shop shop) {
        this.name = name;
        this.subject = shop;
    }

    public void rentCar( Shop shop ) {
        rent_car_behavior.rentCars(shop);
    }

    public void returnCar( Shop shop, Car car) {
        return_car_behavior.returnCar(shop, car);
    }

    public void update() {
        // Not sure what getState would get...
        int n_cars_available = subject.getState();
        updateViable(n_cars_available);
    }

    public boolean getViable() {
        return is_viable;
    }

    public void endDay() {
        for ( int i = 0; i < rented_cars.size(); i++) {
            int days_left_i =  days_left.get(i) - 1;
            days_left.set(i, days_left_i);
            if (days_left.get(i) == 0) {
                returnCar(subject, rented_cars.get(i) );
            }
        }
    }

    protected void _setRentCarBehavior( RentCarBehavior rent_car_behavior ) {
        this.rent_car_behavior = rent_car_behavior;
    }
    protected void _setReturnCarBehavior( ReturnCarBehavior return_car_behavior ) {
        this.return_car_behavior = return_car_behavior;
    }
    
}

class CasualCustomer extends Customer {
    public CasualCustomer(String name, Shop shop) {
        super(name, shop);
        _setRentCarBehavior( new CasualRentCar(this) );
        _setReturnCarBehavior(new UniversalReturnCar(this));
    }
    public boolean isViable(int n_cars_available) {
        
    }
}

class RegularCustomer extends Customer {
    public RegularCustomer(String name, Shop shop) {
        super(name, shop);
        _setRentCarBehavior( new RegularRentCar(this) );
        _setReturnCarBehavior(new UniversalReturnCar(this));
    }
}

class BusinessCustomer extends Customer {
    public BusinessCustomer(String name, Shop shop) {
        super(name, shop);
        _setRentCarBehavior( new BusinessRentCar(this) );
        _setReturnCarBehavior(new UniversalReturnCar(this));
    }
}

