abstract class Car {
    private String plate;

    public Car(String licensePlate) {
        plate = licensePlate;
    }
}



// setup car types

class EconomyCar extends Car {

    public EconomyCar(String licensePlate) {
        super(licensePlate);
        // TODO Auto-generated constructor stub
    }

}

class StandaradCar extends Car {

    public StandaradCar(String licensePlate) {
        super(licensePlate);
        // TODO Auto-generated constructor stub
    }

}

class LuxuryCar extends Car {

    public LuxuryCar(String licensePlate) {
        super(licensePlate);
        // TODO Auto-generated constructor stub
    }

}

class SUVCar extends Car {

    public SUVCar(String licensePlate) {
        super(licensePlate);
        // TODO Auto-generated constructor stub
    }

}

class MinivanCar extends Car {

    public MinivanCar(String licensePlate) {
        super(licensePlate);
        // TODO Auto-generated constructor stub
    }

}