import Cars.*;

public class Shop {
    private List<Cars> availableCars;

    public Shop() {
        // generate the list of cars that the shop has available as an object pool (blocking queue)
    }
}





// object pool
public interface Pool {
    T get();
    void release(T object);
    void shutdown();
}



