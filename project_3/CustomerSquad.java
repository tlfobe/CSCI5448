import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerSquad {
    CustomerFactory fact;
    Shop shop;
    List<Customer> customers = new ArrayList<Customer>();

    public CustomerSquad(Shop shop, int number_customers) {
        this.shop = shop;
        fact = new CustomerFactory(this.shop);

        for(int i = 0; i<number_customers; i++) {
            int n = new Random().nextInt(3);
            Customer t = fact.createCustomer(n);
            shop.attach(t);
            customers.add(t);    
        }
    }

    public void runDay() {
        // day cycle
        System.out.println("Beginning of day lot size: " + shop.size());
        for(Customer c : customers) {
            if(new Random().nextFloat() > 0.5f && c.getViable()) {
                c.rentCars(shop);
                shop.setState();
            }
        }

        System.out.println("Before rented: " + shop.size());

        
        // night cycle
        for(Customer c : customers) {c.endDay();}
        System.out.println("Daily Total: " + shop.getDailyTotal());
        System.out.println("End of day lot size: " + shop.size());
        shop.resetDay();
    }


}


