import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// object pool


interface Pool {
    Car get(int n_nights);
    void release(Car object);
    void shutdown();
}

class CarPool extends CarFactory implements Pool {
    private int size;
    private boolean shutdown;
    private BlockingQueue<Car> objects;
    private List<String> l = new ArrayList<>(
        Arrays.asList(
            "Economy", "StandardCar",
            "Luxury", "SUV", "MiniVan"
            ));
    

    public CarPool(int size) {
        this.size = size;
        shutdown = false;
        init();
    }


    private void init() {
        objects = new LinkedBlockingQueue<Car>();
        for (int i = 0; i < size; i ++) {
            objects.add(getCar(l.get(i % l.size())));
        }

    }

    public Iterator<Car> getList() {
        return objects.iterator(); 
    }

    @Override
    public Car get(int n_nights) {
        if(!shutdown) {
            Car t = null;
            try {
                t = objects.take();
                t.setCost(n_nights);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return t;
        }
        else {
            throw new IllegalStateException("Object pool is already shutdown! Oh no.");
        }
    }

    public void release(Car c) {
        try {
            c.sentBack();
            objects.offer(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void shutdown() {
        objects.clear();
        shutdown = true;
    }

    public int size() {
        return objects.size();
    }
}

interface Subject {
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyAllObservers();
}


public class Shop implements Subject{
    private CarPool carpool;
    private List<Observer> observers = new ArrayList<Observer>();
    public int state;
    private float daily_total = 0.0f;
    private List<Float> cash_flow;


    public Shop(int num_cars) {
        // generate the list of cars that the shop has available as an object pool (blocking queue)
        carpool = new CarPool(num_cars);
        this.state = num_cars;
        cash_flow = new ArrayList<Float>();

    }

    public void resetDay() {
        cash_flow.add(daily_total);
        daily_total = 0.0f;
    }

    public void collectPayment(float money) {
        daily_total += money;
    }

    public void listRemainingCars() {
        Iterator<Car> it = carpool.getList();

        int n = carpool.size();
        System.out.println("Remaining Cars at the beginning of the day: " + n);

        System.out.print("Cars left: ");
        while (it.hasNext()) {
            n --;
            Car c = it.next();
            if(n > 0) {
                System.out.print(c.licensePlate + ", ");
            }
            else {System.out.print(c.licensePlate); }
        }
        System.out.println();






    } 

    public float getDailyTotal() {
        return daily_total;
    }

    public int size() {
        return carpool.size();
    }

    public Car get(int n_nights) {
        return carpool.get(n_nights);
    }

    public void release(Car c) {
        carpool.release(c);
    }

    public int getState() {
        return this.state;
    }

    public void setState() {
        // notify all observers
        this.state = this.size();
        notifyAllObservers();
    }

    public void detach(Observer o) {
        this.observers.remove(o);
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer obs : observers){
            obs.update();
        }
    }

}









