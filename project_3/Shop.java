
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

public abstract class CarPool extends CarFactory implements Pool {
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
    public Car get() {
        if(!shutdown) {
            Car t = null;
            try {
                t = objects.take();
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

public class Shop {
    private CarPool carpool;
    private List<> observers = new List<T>();
    private int cars_left; // can be used to verify customers

    public Shop(int num_cars) {
        // generate the list of cars that the shop has available as an object pool (blocking queue)
        carpool = new CarPool(num_cars);
        cars_left = num_cars;
    }


    public void setState() {
        // notify all observers
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









