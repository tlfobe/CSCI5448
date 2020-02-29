import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

// object pool


public interface Pool {
    Car get();
    void release(Car object);
    void shutdown();
}



public class CarPool extends CarFactory implements Pool {
    private int size;
    private boolean shutdown;
    private BlockingQueue objects;
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
        objects = new LinkedBlockingQueue();
        for (int i = 0; i < size; i ++) {
            objects.add(getCar(l.get(i % l.size())));
        }

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

    @Override
    public void release(Car c) {
        try {
            c.sentBack();
            objects.take(c);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
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
    public void notifyObs();
    public List<Observer> observers = new LinkedList<Observer>();
}


public class Shop implements Subject{
    private CarPool carpool;
    private List<> observers = new List<T>();
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
    public int size() {
        return carpool.size();
    }

    public Car get() {
        carpool.get();
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

    public void attach(T observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (T obs : observers){
            obs.update();
        }
    }

}









