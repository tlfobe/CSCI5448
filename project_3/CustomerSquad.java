import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerSquad {
    CustomerFactory fact;
    Shop shop;
    List<Customer> customers = new ArrayList<Customer>();

    public CustomerSquad(Shop shop, int number_customers) {
        String[] names = new String[] {
            "Laura", "Liam", "Yash", 
            "Lenny", "Chandler", "Jim",
            "Phoebe", "Ross", "Rachel", 
            "Joey", "Monica", "Marcel"};
        this.shop = shop;
        fact = new CustomerFactory(this.shop);

        for(int i = 0; i<number_customers; i++) {
            int n = new Random().nextInt(3);
            Customer t = fact.createCustomer(n, names[i]);
            shop.attach(t);
            customers.add(t);    
        }
    }

    public void runDay() {

        System.out.println(" # # # Current Rental Situation # # # ");
        for(Customer c: customers) {
            if(c.rented_cars.size() > 0) {
                System.out.println(c.name + " currently has: ");
                System.out.print(" \t ");
                for(Car rented : c.rented_cars) {
                    System.out.print(rented.licensePlate + " \t ");
                }
                System.out.println(); System.out.println();
            }
        }

        // day cycle (renting cars)
        for(Customer c : customers) {
            if(new Random().nextFloat() > 0.5f && c.getViable()) {
                // System.out.println(c.name + " is renting a car.");
                System.out.println(c.name + " rents the following car(s): ");
                c.rentCars(shop);
                System.out.println();
                shop.setState();
            }
        }
        
        // night cycle
        for(Customer c : customers) {c.endDay();}
        System.out.println("Daily Total: " + shop.getDailyTotal());
        shop.resetDay();
    }


}


