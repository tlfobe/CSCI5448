
class Shop implements CarPool, Subject{
    private List<Car> availableCars;

    public Shop() {
        // generate the list of cars that the shop has available as an object pool (blocking queue)
    }
}





// object pool
interface CarPool {
    Car get();
    void release(Car car);
    void shutdown();
}



