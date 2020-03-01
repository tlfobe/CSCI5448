import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerSquad {
    CustomerFactory fact;
    List<Customer> customers = new ArrayList<Customer>();

    public CustomerSquad(Shop shop, int number_customers) {
        fact = new CustomerFactory(shop);

        for(int i = 0; i<number_customers; i++) {
            int n = new Random().nextInt(3);
            Customer t = fact.createCustomer(n);
            shop.attach(t);
            customers.add(t);    
        }
    }
}


