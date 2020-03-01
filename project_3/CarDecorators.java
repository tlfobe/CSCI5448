abstract class CarDecorator extends Car {
    protected Car car;
    public CarDecorator(Car car) {
        super(car.licensePlate);
        this.car = car;
    }
    protected Car getBase() {
        if (this instanceof CarDecorator) {
            return this.getBase();
        } else {
            return this.car;
        }
    }
}

class GPS extends CarDecorator {
    public GPS(Car car) {
        super(car);
    }

    public float cost() {
        float cost = this.car.cost();
        if (this.car instanceof EconomyCar) {
            cost += 5.0f; // Adjust costs here!
        } else if (this.car instanceof StandaradCar || this.car instanceof MinivanCar ) {
            cost += 10.0f;
        } else if (this.car instanceof LuxuryCar || this.car instanceof SUVCar) {
            cost += 25.0f;
        }
        return cost;
    }
}

class SateliteRadio extends CarDecorator {
    public SateliteRadio(Car car) {
        super(car);
    }

    public float cost() {
        float cost = this.car.cost();
        if (this.car instanceof EconomyCar) {
            cost += 15.0f; // Adjust costs here!
        } else if (this.car instanceof StandaradCar || this.car instanceof MinivanCar ) {
            cost += 30.0f;
        } else if (this.car instanceof LuxuryCar || this.car instanceof SUVCar) {
            cost += 45.0f;
        }
        return cost;
    }
}

class CarSeat extends CarDecorator {
    public CarSeat(Car car) {
        super(car);
    }

    public float cost() {
        float cost = this.car.cost();
        if (this.car instanceof EconomyCar) {
            cost += 2.5f; // Adjust costs here!
        } else if (this.car instanceof StandaradCar || this.car instanceof MinivanCar ) {
            cost += 5.0f;
        } else if (this.car instanceof LuxuryCar || this.car instanceof SUVCar) {
            cost += 10.0f;
        }
        return cost;
    }
}