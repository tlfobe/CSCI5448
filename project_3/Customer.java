abstract class Subject {
}



abstract class Customer {
    protected String name;
    private int carRentalDays;
    private Bool wantGPS;
    private Bool wantSateliteRadio;
    private int carSeats;
    abstract public void rentCar();
    abstract public void returnCar();

    private _setRentCarBehavior();
    private _setReturnCarBehavior();
    
}

class CasualCustomer extends Customer {

}

class RegularCustomer extends Customer {

}

class BusinessCustomer extends Customer {

}

