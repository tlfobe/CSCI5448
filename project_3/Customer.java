import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
interface Observer {
    public void update();
}

interface Subject {
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyObs();
    public List<Observer> observers = new LinkedList<Observer>();
}

abstract class Customer implements Observer {
    protected String name;
    // Might write extra constructors to set these if so desired

    protected RentCarBehavior rent_car_behavior;
    protected ReturnCarBehavior return_car_behavior;
    protected List< Car > rented_cars;
    protected List< Integer > days_left;
    protected Shop subject;

    public Customer(String name, Shop shop) {
        this.name = name;
        this.subject = shop;
    }

    public void rentCar( Shop shop ) {
        rent_car_behavior.rentCars(shop);
    }

    public void returnCar( Shop shop, Car car) {
        return_car_behavior.returnCars(shop);
    }

    public void update() {
        // Not sure what getState would get... 
        if (subject.getState()) {
            incrDay();
        }
    }

    protected void incrDay() {
        for ( int i = 0; i < rented_cars.size(); i++) {
            int days_left_i =  days_left.get(i) - 1;
            days_left.set(i, days_left_i);
            if (days_left.get(i) == 0) {
                returnCar( subject, rented_cars.get(i) );
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

