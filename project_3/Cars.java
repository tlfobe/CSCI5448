public interface Car {  
    public String licensePlate;
    public float get_cost();
    public boolean rented();
    
}

class EconomyCar implements Car {
    private float cost = 100.0;

    public EconomyCar(String plate){
        licensePlate = plate;
    }

    public float get_cost() {
        return cost;
    }
}

class StandardCar implements Car {
    private float cost = 100.0;

    public StandaradCar(String plate) {
        licensePlate = plate;
    }

    public float get_cost() {
        return cost;
    }
}

class LuxuryCar implements Car {
    private float cost = 200.0;

    public LuxuryCar(String plate) {
        licensePlate = plate;
    }

    public float get_cost() {
        return cost;
    }
}

class SUVCar implements Car {
    private float cost = 150.0;

    public SUVCar(String plate) {
        licensePlate = plate;
    }

    public float get_cost() {
        return cost;
    }
}

class MinivanCar implements Car {
    private float cost = 200.0;

    public MinivanCar(String plate) {
        licensePlate = plate;
    }

    public float get_cost() {
        return cost;
    }
}


public class CarFactor {
    private String generatePlate() {
        String p = "";
        int n = 'Z' - 'A' + 1;
        int m = '9' - '0' + 1;
        for (int i = 0; i < 3; i++) {
            char c = (char) ('A' + Math.random() * n);
            p += c;
        }
        for (int j = 0; j < 3; j ++) {
            char d = (char) ('0' + Math.random() * m);
            p += d;
        }

        return p;
    }

    public Car getCar(String carType) {
        if (carType.equalsIgnoreCase("Economy")) {
            return new EconomyCar(generatePlate());
        }
        else if (carType.equalsIgnoreCase("StandardCar")) {
            return new StandardCar(generatePlate());
        }
        else if (carType.equalsIgnoreCase("Luxury")) {
            return new LuxuryCar(generatePlate());
        }
        else if (carType.equalsIgnoreCase("SUV")) {
            return new SUVCar(generatePlate());
        }
        else if (carType.equalsIgnoreCase("MiniVan")) {
            return new MinivanCar(generatePlate());
        }
        else {
            return null;
        }
    
    }
}


// /*
// in shop:



// if(wantsGPS):
//     rentalCar = GPS(rentalCar)
// for childseat in num_childSeats:
//     rentalCar = childSeat(rentalCar)




// */