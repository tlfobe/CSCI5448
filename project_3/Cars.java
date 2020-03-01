abstract class Car{
    public String licensePlate = "temp";
    protected float base_cost;    
    protected float cost;

    public void sentBack() {
        cost = base_cost;
    }

    public void setCost(int n){
        cost = n*base_cost;
    }

    public float cost() {
        return cost;
    }
}

class EconomyCar extends Car {
    
    
    public EconomyCar(String plate){
        base_cost = 100.0f;
        licensePlate = plate;
    }

    public float cost() {
        return cost;
    }
}

class StandardCar extends Car {

    public StandaradCar(String plate) {
        base_cost = 100.0f;
        licensePlate = plate;
    }

    public float cost() {
        return cost;
    }
}

class LuxuryCar extends Car {
    

    public LuxuryCar(String plate) {
        base_cost = 200.0f;
        licensePlate = plate;
    }

    public float cost() {
        return cost;
    }
}

class SUVCar extends Car {
    

    public SUVCar(String plate) {
        base_cost = 150.0f;
        licensePlate = plate;
    }

    public float cost() {
        return cost;
    }
}

class MinivanCar extends Car {
    

    public MinivanCar(String plate) {
        base_cost = 200.0f;
        licensePlate = plate;
    }

    public float cost() {
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


